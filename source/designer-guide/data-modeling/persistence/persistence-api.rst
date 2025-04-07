.. _persistence-api:

Persistence API
---------------

The |ivy| Persistence API is used to load entity objects directly
from the database or save/update them on the database. The Persistence
API can be accessed by IvyScript anywhere scripting is supported. The
Persistence API can only deal with entity objects, means objects of type
:ref:`persistence-entity-classes`. The Persistence API
can be found under ``ivy.persistence.``\ *<persistence unit>*. Here you
find all the methods for finding, persisting, updating and querying
entity objects. See ``IIvyEntityManager`` fore more information. Replace
*<persistence unit>* with the name of a persistence unit. The
persistence units can be configured with the :ref:`persistence-configuration-editor`.


.. _persistence-api-persist:

Persist an Entity Object
^^^^^^^^^^^^^^^^^^^^^^^^

To persist (save/create object on the database) you can use the
``persist()`` method of the Persistence API.

.. warning::

   This method only works properly if the entity object and all the
   associated objects are not jet persistent. Otherwise you have to use
   the merge method.

Example (Product is an Entity Class):

::

   // persist new created product
   Product product;
   product.name = "Product name";
   product.nr = 12;
   ivy.persistence.<persistence unit>.persist(product);

   // get id of new created product
   Number newProductId = product.id;


Find an Entity Object by ID
^^^^^^^^^^^^^^^^^^^^^^^^^^^

To find an entity object by id (select object on the database) you can
use the ``find()`` method of the Persistence API.

Example (Product is an Entity Class):

::

   // load product with id 1 from the database
   Product product = ivy.persistence.<persistence unit>
   .find(Product.class, 1) as Product;


.. _persistence-api-merge:

Merge an Entity Object
^^^^^^^^^^^^^^^^^^^^^^

To merge (update or save/create object on the database) you can use the
``merge()`` method of the Persistence API.

.. warning:

   Only the returned entity object of this method is the really updated
   or saved/created object. The object given to this method is not
   changed.

Example update (Product is an Entity Class):

::

   ...
   // change before loaded product
   product.name = "New product name"
   Product updatedProduct = ivy.persistence.<persistence unit>
   .merge(product) as Product;

Example save/create (Product is an Entity Class):

::

   // save new created product
   Product product;
   product.name = "Product name";
   product.nr = 12;
   Product savedProduct = ivy.persistence.<persistence unit>
   .merge(product) as Product;

   // get id of new created product
   Number newProductId = savedProduct.id;

.. _persistence-api-remove:

Remove an Entity Object
^^^^^^^^^^^^^^^^^^^^^^^

To remove (delete object on the database) you can use the ``remove()``
method of the Persistence API.

Example (Product is an Entity Class):

::

   ...
   // delete the product from the database
   ivy.persistence.<persistence unit>.remove(product);

.. _persistence-api-refresh:

Refresh an Entity Object
^^^^^^^^^^^^^^^^^^^^^^^^

To refresh (reload object from the database) you can use the
``refresh()`` method of the Persistence API.

Example (Product is an Entity Class):

::

   ...
   // change before loaded product
   product.name = "New product name"
   // reload object from the database and revert local changes
   ivy.persistence.<persistence unit>.refresh(product);


Persistence Queries (JPA QL)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

With the Persistence API it is possible to execute Java Persistence API
Query Language (JPA QL) statements. See ``IIvyQuery`` for more
information about the Query API. The query language based around the
objects that are persisted but with syntax very similar to SQL. You
always have to use the names of the Entity Class and the attributes and
not the names from the database.


Case Sensitivity
~~~~~~~~~~~~~~~~

Queries are case-insensitive, except for names of Java classes and
properties. So ``SeLeCT`` is the same as ``sELEct`` is the same as
``select`` but ``PRODUCT`` is not ``product`` and ``foo.barSet`` is not
``foo.BARSET``. This manual uses lowercase JPA QL keywords.


Single Result
~~~~~~~~~~~~~

To execute a JPA query where you are expecting a single value to be
returned you would call ``getSingleResult()``. This will return the
single Object. If the query returns more than one result then you will
get an exception. This should not be called with "UPDATE"/"DELETE"
queries.

Example (Product is an Entity Class):

::

   Product product = ivy.persistence.<persistence unit>
   .createQuery("select p from Product p where p.id = :id")
   .setParameter("id", 1)
   .getSingleResult() as Product;

.. warning::

   Calling this method in automatic transaction mode (by default) will
   close the recordset automatically. Consequently you cannot invoke
   this method multiple times or in combination with ``getResultList()``
   on the same query.


Result List
~~~~~~~~~~~

To execute a JPA query you would typically call ``getResultList()``.
This will return a list of results. This should not be called with
"UPDATE"/"DELETE" queries.

Example (Product is an Entity Class):

::

   List<Product> products = ivy.persistence.<persistence unit>
   .createQuery("select p from Product p where p.price > :price")
   .setParameter("price", 10)
   .getResultList();

.. warning::

   Calling this method in automatic transaction mode (by default) will
   close the recordset automatically. Consequently you can not invoke
   this method multiple times or in combination with
   ``getSingleResult()`` on the same query.


Execute Update
~~~~~~~~~~~~~~

To execute a JPA UPDATE/DELETE query you would call ``executeUpdate()``.
This will return the number of objects changed by the call. This should
not be called with "select" queries.

Example delete (Product is an Entity Class):

::

   // delete all products
   Number deletedRows = ivy.persistence.<persistence unit>
   .createQuery("delete from Product p")
   .executeUpdate()

Example update (Product is an Entity Class):

::

   // update product name
   Number updatedRows = ivy.persistence.<persistence unit>
   .createQuery("update Product set name = :newName where name = :oldName")
   .setParameter( "newName", "New Product Name" )
   .setParameter( "oldName", "Old Product Name" )
   .executeUpdate();


Parameter Binding
~~~~~~~~~~~~~~~~~

The JPA Queries supports named and numbered parameters and provides
methods for setting the value of a particular parameter.

.. tip::

   You should always use parameter binding and do not build the query
   with string concatenation, because of performance reasons.

Example with named parameter:

::

   ivy.persistence.<persistence unit>
   .createQuery("select p from Product p where p.price > :price")
   .setParameter("price", 10)

Example with positional parameter:

::

   ivy.persistence.<persistence unit>
   .createQuery("select p from Product p where p.price > ?1 and p.amount <= ?2")
   .setParameter(1, 10).setParameter(2, 80)


Paging the Result
~~~~~~~~~~~~~~~~~

To specify the range of a query you have the two methods
``setFirstResult()`` and ``setMaxResults()`` available. The start
position of the first result, numbered from 0.

Example (Product is an Entity Class):

::

   List<Product> products = ivy.persistence.<persistence unit>
   .createQuery("select p from Product p where p.price > :price")
   .setParameter("price", 10)
   .setFirstResult(40)
   .setMaxResults(20).getResultList();

The call to ``setFirstResult(40)`` means starting from the fortieth
object. The call to ``setMaxResults(20)`` limits the query result set to
20 objects (rows) returned by the database.


Ordering
~~~~~~~~

JPA QL provide an ORDER BY clause for ordering query results, similar to
SQL.

Returns all Products ordered by name:

::

   from Product p order by p.name

You specify ascending and descending order using asc or desc:

::

   from Product p order by p.name desc

You may order by multiple properties:

::

   from Product p order by p.name asc, p.description desc


Distinct Results
~~~~~~~~~~~~~~~~

When you use a select clause, the elements of the result are no longer
guaranteed to be unique.

DISTINCT eliminates duplicates from the returned list of product
descriptions.

::

   select distinct p.description from Product p


Comparison Expressions
~~~~~~~~~~~~~~~~~~~~~~

JPA QL support the same basic comparison operators as SQL. Here are a
few examples that should look familiar if you know SQL:

Binary comparison (=, <>, <, >, >=, <=, [NOT] BETWEEN, [NOT] IN):

::

   from Product p where p.amount = 100
   from Product p where p.amount <> 100
   from Product p where p.amount > 100
   from Product p where p.amount <= 100
   from Product p where p.amount between 1 and 10
   from Product p where p.name in ('Product A', 'Product B')            

Null check (IS [NOT] NULL):

::

   from Product p where p.name is null
   from Product p where p.name is not null          

Arithmetic expressions (+, -, \*, /):

::

   from Product p where ( p.amount / 0.71 ) - 100.0 > 0.0

The LIKE operator accepts a string value as input parameter in which an
underscore (_) stands for any single character, a percent (%) character
stands for any sequence of characters (including the empty sequence),
and all other characters stand for themselves:

::

   from Product p where p.name like 'A%'
   from Product p where p.name not like '_a_'

Logical operators (NOT, AND, OR):

::

   from Product p
       where p.name like 'A%' and p.price > 10

Expressions with collections (IS [NOT] EMPTY, [NOT] MEMBER [OF]):

::

   from Product p where p.customers is not empty
   from Product p, Category c where p member of c.products

.. table:: JPA QL operator precedence

   +-----------------------------------+-----------------------------------+
   | Operators                         | Description                       |
   +===================================+===================================+
   | .                                 | Navigation path expression        |
   |                                   | operator                          |
   +-----------------------------------+-----------------------------------+
   | +, -                              | Unary positive or negative        |
   |                                   | signing (all unsigned numeric     |
   |                                   | values are considered positive)   |
   +-----------------------------------+-----------------------------------+
   | \*, /                             | Regular multiplication and        |
   |                                   | division of numeric values        |
   +-----------------------------------+-----------------------------------+
   | +, -                              | Regular addition and subtraction  |
   |                                   | of numeric values                 |
   +-----------------------------------+-----------------------------------+
   | =, <>, <, >, >=, <=, [NOT]        | Binary comparison operators with  |
   | BETWEEN, [NOT] IN, IS [NOT] NULL, | SQL semantics                     |
   | [NOT] LIKE                        |                                   |
   +-----------------------------------+-----------------------------------+
   | IS [NOT] EMPTY, [NOT] MEMBER [OF] | Binary operators for collections  |
   |                                   | in JPA QL                         |
   +-----------------------------------+-----------------------------------+
   | NOT, AND, OR                      | Logical operators for ordering of |
   |                                   | expression evaluation             |
   +-----------------------------------+-----------------------------------+


Calling Functions
~~~~~~~~~~~~~~~~~

An extremely powerful feature of JPA QL is the ability to call SQL
functions in the where and HAVING clauses of a query.

Lower cases or upper cases a string (LOWER(string), UPPER(string)):

::

   from Product p where lower(p.name) = 'product name'
   from Product p where upper(p.name) = 'PRODUCT NAME'

Another common expression is concatenation, although SQL dialects are
different here, JPA QL support a portable concat(string1, string2)
function:

::

   from Product p where concat(p.name, p.description) like 'A% B%'

Size of a collection (SIZE(collection)):

::

   from Product p where size(p.customers) > 10

.. table:: JPA QL functions

   +-----------------------+-----------------------+-----------------------+
   | Function              | Return                | Description           |
   +=======================+=======================+=======================+
   | UPPER(string),        | string                | Lower cases or upper  |
   | LOWER(string)         |                       | cases a *string*      |
   |                       |                       | value                 |
   +-----------------------+-----------------------+-----------------------+
   | CONCAT(string1,       | string                | Concatenates *string* |
   | string2)              |                       | values to one string  |
   +-----------------------+-----------------------+-----------------------+
   | SUBSTRING(string,     | string                | Substring string      |
   | offset, length)       |                       | values (*offset*      |
   |                       |                       | starts at 1)          |
   +-----------------------+-----------------------+-----------------------+
   | TRIM(                 | string                | Trims spaces on BOTH  |
   | [[BOTH|LEADING|TRAILI |                       | sides of *string* if  |
   | NG]                   |                       | no *char* or other    |
   | char [from]] string)  |                       | specification is      |
   |                       |                       | given                 |
   +-----------------------+-----------------------+-----------------------+
   | LENGTH(string)        | number                | Gets the length of a  |
   |                       |                       | *string* value        |
   +-----------------------+-----------------------+-----------------------+
   | LOCATE(search,        | number                | Searches for position |
   | string, offset)       |                       | of *search* in        |
   |                       |                       | *string* starting at  |
   |                       |                       | *offset*              |
   +-----------------------+-----------------------+-----------------------+
   | ABS(number),          | number                | Returns an absolute   |
   | SQRT(number),         |                       | of same type as       |
   | MOD(dividend,         |                       | input, square root as |
   | divisor)              |                       | double, and the       |
   |                       |                       | remainder of a        |
   |                       |                       | division as an        |
   |                       |                       | integer               |
   +-----------------------+-----------------------+-----------------------+
   | SIZE(collection)      | integer               | Size of a             |
   |                       |                       | *collection*; returns |
   |                       |                       | an integer, or 0 if   |
   |                       |                       | empty                 |
   +-----------------------+-----------------------+-----------------------+


Aggregate functions
~~~~~~~~~~~~~~~~~~~

The aggregate functions that are recognized in JPA QL are ``count()``,
``min()``, ``max()``, ``sum()`` and ``avg()``.

This query counts all the Products:

::

   Number productCount = ivy.persistence.<persistence unit>
   .createQuery("select count(p) from Product p").getSingleResult() as Number;                

This query calculates the average the sum, the maximum and the minimum
from the amount of all products:

::

   select avg(p.amount), sum(p.amount), max(p.amount) min(p.amount) from Product p


Accessibility
^^^^^^^^^^^^^

You can use the Persistence API everywhere you have the |ivy| variable in
the IvyScript. Use ``ivy.persistence.``\ *<persistence unit>*. Here you
find all the methods for finding, persisting, updating and querying
entity objects. Replace *<persistence unit>* with the name of a
persistence unit.
