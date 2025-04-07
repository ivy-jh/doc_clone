IvyScript Reference
===================


Operators
---------

.. table:: IvyScript Field Access and Type Cast Operators
   :widths: 10 30 60

   +-----------------------+-----------------------+-------------------------------------------------+
   | Operator              | Explanation           | Usage                                           |
   +=======================+=======================+=================================================+
   | .                     | Field and method      | ``in.customer.name``                            |
   |                       | access of Ivy objects | addresses the name                              |
   |                       |                       | attribute in the data                           |
   |                       |                       | structure                                       |
   |                       |                       |                                                 |
   |                       |                       | ``in.message.length()``                         |
   |                       |                       | calls the method                                |
   |                       |                       | length()                                        |
   +-----------------------+-----------------------+-------------------------------------------------+
   | .#                    | Field access with     | ``in.#customer == null``                        |
   |                       | suppressed auto       |                                                 |
   |                       | initialisation        | null check of                                   |
   |                       |                       | customer which is not                           |
   |                       |                       | initialised                                     |
   +-----------------------+-----------------------+-------------------------------------------------+
   | as                    | Type cast operator    | ``in.anObject as Date``                         |
   |                       |                       | casts the object to a                           |
   |                       |                       | Date                                            |
   +-----------------------+-----------------------+-------------------------------------------------+

.. table:: IvyScript Logic Operators
   :widths: 20 40 40
   
   +----------+-----------------------+---------------------------------+
   | Operator | Explanation           | Usage                           |
   +==========+=======================+=================================+
   | >        | greater than          | ``5 > 3`` is true               |
   +----------+-----------------------+---------------------------------+
   | <        | less than             | ``5 < 3`` is false              |
   +----------+-----------------------+---------------------------------+
   | ==       | equals                | ``5 == 5`` is true              |
   |          |                       |                                 |
   |          | (Java equals)         | ``"Hello" == "HELLO"`` is false |
   +----------+-----------------------+---------------------------------+
   | !=       | unequal               | ``7 != 2`` is true              |
   +----------+-----------------------+---------------------------------+
   | >=       | greater than or equal | ``7 >= 6`` is true              |
   +----------+-----------------------+---------------------------------+
   | <=       | less than or equal    | ``2 <= 5`` is true              |
   +----------+-----------------------+---------------------------------+
   | &&       | Boolean AND           | ``true && true`` is true        |
   +----------+-----------------------+---------------------------------+
   | \|\|     | Boolean OR            | ``true || false`` is true       |
   +----------+-----------------------+---------------------------------+
   | !        | Boolean NOT           | ``! true`` is false             |
   +----------+-----------------------+---------------------------------+

.. table:: IvyScript Arithmetic Operators

   +----------+-----------------------+---------------------------------------+
   | Operator | Explanation           | Usage                                 |
   +==========+=======================+=======================================+
   | \+       | Addition              | ``12.5+17.0`` is 29.5                 |
   |          |                       |                                       |
   |          | String Concatenation  | ``"Hello "+"World"`` is "Hello World" |
   +----------+-----------------------+---------------------------------------+
   | \-       | Subtraction           | ``3020-12`` is 3008                   |
   +----------+-----------------------+---------------------------------------+
   | \*       | Multiplication        | ``2*4`` is 8                          |
   +----------+-----------------------+---------------------------------------+
   | /        | Division              | ``7/2`` is 3.5                        |
   +----------+-----------------------+---------------------------------------+
   | %        | Modulo Division       | ``7%2`` is 1                          |
   +----------+-----------------------+---------------------------------------+
   | \*\*     | Power                 | ``2%5`` is 32                         |
   +----------+-----------------------+---------------------------------------+
   | ++       | Increment             | ``in.n++``                            |
   +----------+-----------------------+---------------------------------------+
   | \--      | Decrement             | ``in.n--``                            |
   +----------+-----------------------+---------------------------------------+
   | \-       | Negative Number value | ``-9``                                |
   +----------+-----------------------+---------------------------------------+


.. _ivyscript-reference-data-types:

Ivy Script Data Types
---------------------


Boolean
~~~~~~~

A boolean has the values ``true`` and ``false``.
The IvyScript ``Boolean`` is based on the
:java-api:`java.lang.Boolean </java/lang/Boolean.html>`
but has a simplified class reference definition.
Type conversion and format methods has been added while most other methods are hidden.


Date
~~~~

The :public-api:`Date </ch/ivyteam/ivy/scripting/objects/Date.html>`
class represents a date without time of day.

- Date constant objects are entered in the ISO-8601 format as ``'YYYY-MM-DD'``,
  where YYYY is for the year, MM for month and DD for day.
- Accepted is also the format: ``'DD.MM.YYYY'``.
- ``new Date()`` returns the current date.


DateTime
~~~~~~~~

The :public-api:`DateTime </ch/ivyteam/ivy/scripting/objects/DateTime.html>` class represents a date with time.

- Constant ``DateTime`` objects are entered in the ISO-8601 format as ``'YYYY-MM-DD hh:mm'`` or ``'YYYY-MM-DD hh:mm:ss'``.
  YYYY is for the year, MM for month, DD for day hh for hours, mm for minutes and ss for seconds.
- Accepted is also the format: ``'DD.MM.YYYY hh:mm`` or ``'DD.MM.YYYY hh:mm:ss'``.
- ``new DateTime()`` returns the current date and time.


Time
~~~~

The :public-api:`Time </ch/ivyteam/ivy/scripting/objects/Time.html>` class represents a time of day.

- ``Time`` constants are entered as ``'hh:mm'`` or ``'hh:mm:ss'``,
  where hh is for hour, mm for minutes and ss for seconds
- ``new Time()`` returns the current time.


.. _ivyscript-datatype-duration:

Duration
~~~~~~~~

The :public-api:`Duration </ch/ivyteam/ivy/scripting/objects/Duration.html>` class represents **time periods**.

- You enter a duration in the ISO 8601 time period format such as: ``'12h20m'`` or ``'12h20m30s'``
- An example for the full format is: ``'P3Y6M4DT12h30m10s'``


Number
~~~~~~

IvyScript Numbers are :java-api:`Java Numbers </java/lang/Number.html>`.
Number objects are integer or fixed-point numbers or floating point numbers.

- Integer are entered as: ``23`` or ``-10``
- Fixed Point number are entered as: ``0.1`` or ``-123.57458``
- Floating point numbers are given with exponent: ``1.2345E3`` or ``42.3234E-4``
- The IvyScript Numbers are ``java.lang.Number`` objects but has a simplified and
  extended class reference definition. Format methods has been added for
  convenience.


String
~~~~~~

:java-api:`String </java/lang/String.html>` objects represent character strings.

- You enter a String literal in double quotes: ``"Hello John"``
- Strings can be concatenated with the + operator: ``"Hello "+"John"``
- The IvyScript Strings are ``java.lang.String`` objects but has a
  simplified and extended class reference definition. Conversion and
  format methods has been added for convenience.


Record
~~~~~~

Usually Records are obtained in the context of data base queries, where
they represent a row in a table.
:public-api:`Record </ch/ivyteam/ivy/scripting/objects/Record.html>`
objects are similar to a ``List`` where each element has an assigned field name.


.. _ivyscript-datatype-recordset:

Recordset
~~~~~~~~~

A :public-api:`RecordSet </ch/ivyteam/ivy/scripting/objects/Recordset.html>` may be the result of a database query representing part of a
table.


XML
~~~

The :public-api:`Xml </ch/ivyteam/ivy/scripting/objects/Xml.html>` class is used
for the processing of XML documents. You can create
XML Documents or apply XPath expression to filter and extract values.


Tree
~~~~

The :public-api:`Tree </ch/ivyteam/ivy/scripting/objects/Tree.html>` data type holds
the data for a tree. A tree is a hierarchy of nodes
and sub nodes. A node in the tree contains a value object and an info
string and might have any number of attached children sub nodes.


Binary
~~~~~~

A :public-api:`Binary </ch/ivyteam/ivy/scripting/objects/Binary.html>` object is a
wrapper object for a byte array.


.. _ivyscript-datatype-list:

List
~~~~

:public-api:`List </ch/ivyteam/ivy/scripting/objects/List.html>` objects
can contain any number of other objects of any type. Each
object in a list has an index which starts at zero.

- Examples are: ``[1,2,3]`` a list with three numbers
- ``[1,"Red",2,"Green",3,"Blue"]`` a list with different objects.
- Beside this general list type, so called typed list exists. A typed list
  can only contain objects of certain type.
- Those list types are written as follows: ``List<aClass>``


.. _ivyscript-reference-file:

File
~~~~

A :public-api:`File </ch/ivyteam/ivy/scripting/objects/File.html>` object
can be used to read/write temporary or persistent data.
IvyScript ``Files`` are created in a confined area that belongs to the
running application. Temporary files are created in a session-specific
file area and are automatically deleted if a session ends. Temporary
Files can be made persistent.

IvyScript Files are always addressed relatively, i.e., absolute
addressing will lead to errors. You can create folders and files, i.e., a
hierarchical structure, but you can not navigate outside the confined
area (which is also the reason why absolute File paths are disallowed).

.. tip::

   You can always use ``java.io.File`` as an alternative to the
   IvyScript File object. However, in this case you must always use the
   Java File fully qualified, i.e., you can not import the class. Any
   IvyScript File can be transformed into a Java File (e.g., if needed to
   pass as parameter to a Java method).

.. _ivyscript-reference-environmentvariable:

The Environment Variable ``ivy``
--------------------------------

The ``ivy`` environment variable is provided to access the context of the
current process. The environment information is available as fields on
the global ``ivy`` variable, e.g., to access the CMS of the current
project you use:

::

   String okMessage = ivy.cms.co("/text/messages/ok");

.. note::

   **Access from IvyScript:**

   The variable ``ivy`` is available wherever you can use *IvyScript*,
   e.g., on *Step* elements or in *output tables* of other elements.

   **Access from Java:**

   You can also access ``ivy`` from a Java context, e.g., from helper classes. To
   do so, simply import the :public-api:`ch.ivyteam.ivy.environment.Ivy
   </ch/ivyteam/ivy/environment/Ivy.html>` class and use it's static API.

   Please note that it is necessary that the Java code which makes use of the
   ``ivy`` context variable must run within an Axon Ivy request. Otherwise,
   context information will not be available, most likely resulting in an
   ``EnvironmentNotAvailableException``.

   **Access from JSP:**

   The ``ivy`` variable is also accessible from JSP. You can import the
   class :public-api:`ch.ivyteam.ivy.page.engine.jsp.IvyJSP </ch/ivyteam/ivy/page/engine/jsp/IvyJSP.html>`
   and declare the variable ``ivy`` in your JSP as follows:

   ::

      <%@ page import="ch.ivyteam.ivy.page.engine.jsp.IvyJSP"%>
      <jsp:useBean id="ivy" class="ch.ivyteam.ivy.page.engine.jsp.IvyJSP" scope="session"/>
                      

The following environment objects are available on ``ivy`` (details of
the objects are described in the :public-api:`Public API </>`):

-  ``cal`` - an :public-api:`IDefaultBusinessCalendar </ch/ivyteam/ivy/application/calendar/IDefaultBusinessCalendar.html>`
   object that gives access to business calendar informations and calculations.

-  ``request`` - an :public-api:`IProcessModelVersionRequest </ch/ivyteam/ivy/request/IProcessModelVersionRequest.html>`
   object, the representation of the request against the server to execute the
   current step

-  ``response`` - an :public-api:`IResponse </ch/ivyteam/ivy/request/IResponse.html>` object, the response of the Axon Ivy Engine
   on the request to execute the most current step

-  ``wf`` - an :public-api:`IWorkflowContext </ch/ivyteam/ivy/workflow/IWorkflowContext.html>` object giving access to all workflow
   objects (all tasks, all cases) of all users for the application under
   execution. Can be used to build a whole workflow administration UI
   application, find tasks, cases, do statistics, etc. There is a
   workflow context for each application and vice versa.

-  ``session`` - an :public-api:`IWorkflowSession </ch/ivyteam/ivy/workflow/IWorkflowSession.html>` object gives access to all
   workflow objects (task and cases) that belongs to the user of the
   current session. A workflow object belongs to a user if:

   -  A task is assigned to him or a role he owns.
   -  A task he is currently working on.
   -  A task he worked on in the past (needs permission).
   -  A task that a member of a role he owns has worked on in the past
      (needs permission).
   -  A case he has started (needs permission).
   -  A case that have been started by a member of a role he owns (needs
      permission),
   -  A case that has a task which he worked on (needs permission).
   -  A case that has a task which a member of a role he owns has worked
      on in the past (needs permission).

-  ``task`` - an :public-api:`ITask </ch/ivyteam/ivy/workflow/ITask.html>` object, the representation of the user's
   current work unit in the process under execution.

-  ``case`` - an :public-api:`ICase </ch/ivyteam/ivy/workflow/ICase.html>` instance that represents the current process
   under execution

-  ``cms`` - a :public-api:`IContentManagmentSystem </ch/ivyteam/ivy/cm/IContentManagementSystem.html>` object representing the CMS
   used in this project.

-  ``html`` - a :public-api:`IHTMLDialogContext </ch/ivyteam/ivy/htmldialog/IHTMLDialogContext.html>` object specifies the Axon Ivy
   HTML environment

-  ``log`` - a :public-api:`Logger </ch/ivyteam/log/Logger.html>` object. You can define log outputs here that
   will be collected for each run. You can see these log entries in the
   :ref:`Runtime Log View <simulate-process-models-debugger-runtimelog-view>`.
   
-  ``security`` - a :public-api:`ISecurityContext </ch/ivyteam/ivy/security/ISecurityContext.html>` object giving access to all 
   security objects (all users, roles, sessions) for the application under execution. 
   Can be used to build a whole user and role administration UI application. 
   There is a security context for each application and vice versa.   

-  ``extensions`` - a :public-api:`IExtensions </ch/ivyteam/ivy/extension/IExtensions.html>` instance allowing access to
   Axon Ivy ``extensions``

-  ``datacache`` - the reference to the :public-api:`IDataCacheContext </ch/ivyteam/ivy/data/cache/IDataCacheContext.html>` instances
   for the application and session (see :ref:`data-cache`)

-  ``persistence`` - references to the existing persistence units in
   this application (see :ref:`persistence-configuration-editor`
   and :ref:`persistence-api` for more information about the API of the
   :ref:`Persistence <persistence>`)

-  ``var`` - references to the variables that are defined for
   this application (see :ref:`variables` for more information)

-  ``rules`` - references to the :ref:`rule engine integration <rule-engine>` within Axon Ivy.


.. note::

   The ``html`` object is only available within a business process.
