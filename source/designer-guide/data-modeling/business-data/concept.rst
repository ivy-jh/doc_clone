Business Data Concept
---------------------

The Business Data Store implements a document store. Beside
the stored value, the repository stores additional information about the
Business Data, like an identifier, a version, and the creation / update
date.

A value data class can have fields of complex types, which allows you to
create an object hierarchy or -tree. The storage mechanism can handle
recursions and will respect objects of same instance. If the same
instance of an object is referenced in a field and in a list - after
storing and loading the value - the loaded value will have the identical
structure; the field as well as the list entry will reference the same
instance.


Identity
~~~~~~~~

A Business Data value is identified by an identifier given by the
repository and its data class.

A unique id is generated if a Business Data value is stored for the first time.
If there is a field of type ``String`` with the name ``id`` in the Business Data
class, the generated id will be stored into this field, too.

It is also possible to use your own id if you set the id to the Business Data
value before saving it for the first time.


.. _business-case-data:

Business Case Data
~~~~~~~~~~~~~~~~~~

The handling of identifiers of Business Data values is complex because you have
to manage the identifiers in the process data manually. Therefore, the Business
Data Store can store data in the context of a business case. You can activate
this by marking a data class with the ``@BusinessCaseData`` annotation. In the
:ref:`data-class-editor`, change the type of your data class to *Business Data*.
Now, all values of the annotated data class are automatically associated with
the current business case. You can use the ``get`` method to load the value
associated with the current business case. If no value is associated, it returns
a new object.

Migrate data classes
~~~~~~~~~~~~~~~~~~~~

You can add and remove fields in the value data class hierarchy. New fields will
be initialized with ``null`` when old values get loaded. Deleted fields will no
longer be available. The current data of deleted fields will remain persisted until the new value
gets stored with the new data - which will override the old data.

Optimistic locking
~~~~~~~~~~~~~~~~~~

Business Data supports optimistic locking. It is possible to check if the
current version is up to date and save only if there are differences. It is
possible to update a value partially so that multiple participants can work on
different parts of the same Business Data value. See the *Concurrent
Modification* :ref:`WorkflowDemos projects <importing-demo-projects>` for a
practical example.
