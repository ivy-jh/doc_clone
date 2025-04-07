.. _ivyscript-java-integration:

IvyScript-Java Integration
==========================

Call Java Methods and Fields
----------------------------

You can easily write own Java classes and use them directly in
IvyScript. You can call static methods and fields from Java classes
(e.g., ``java.lang.Math``). You have to address the class with the
qualified name or use import statements. If a Java method has no return
parameter (void) then the called object of the method is returned (e.g.
a call to ``user.setName(...)`` returns object ``user``).

::

   import java.lang.Math;

   Number r = Math.random();
   Number pi = Math.PI;

   out.n= r*pi;


Working with Different Date, Time and DateTime Implementations
--------------------------------------------------------------

When working with Databases and Web Services in Axon Ivy, then different
implementations of Date, Time and combined Date-Time information are
encountered (e.g., ``java.util.Date``, ``java.sql.Date``,
etc). To further complicate matters, some of those implementations are -
for historical reasons - mutable (e.g., ``java.util.Date``) which is from
today's perspective an unwelcome behavior. This has been remedied by
some other implementations.

To facilitate working with values of those different types, IvyScript
will *always* convert them to the corresponding, *immutable* IvyScript
base types whenever such values are encountered, according to the
following table:

.. table:: Automatic conversion of foreign Date / Time values

   +--------------------------+------------------+
   | Java type                | Ivy type         |
   +==========================+==================+
   | JDBC (SQL) ``Timestamp`` | Ivy ``DateTime`` |
   +--------------------------+------------------+
   | JDBC (SQL) ``Date``      | Ivy ``Date``     |
   +--------------------------+------------------+
   | JDBC (SQL) ``Time``      | Ivy ``Time``     |
   +--------------------------+------------------+
   | Java ``Date``            | Ivy ``DateTime`` |
   +--------------------------+------------------+

The automatic conversion into IvyScript types takes place transparently.
The developer should therefore only think in terms of the IvyScript
``Date`` / ``Time`` types. No explicit conversion has to be made,
neither when reading nor when writing those types.

.. warning::

   As a general rule, *do not create any variables or objects of foreign
   (i.e., Java) Date / Time types inside IvyScript* . Although a
   statement such as

   ::

      java.util.Date myDate = new java.util.Date();
                  

   is valid and permitted in IvyScript, the actual type of the *myDate*
   object will always be IvyScript ``DateTime``, due to the
   auto-conversion. This can lead to confusion.

When trying to find out if date or time values are ``null`` or not
initialized, developers should always use the ``is initialized``
operator rather than testing against ``null``:

::

   // recommended style
   if (person.birthday is initialized) ...
   if (in.lunchTime is initialized) ...
   if (schedule.appointment is initialized) ...

   // unsafe style, not recommended
   if (person.birthday != null) ...
   if (in.lunchTime != null) ...
   if (schedule.appointment != null) ...
                   


Auto Casting Rules
------------------

IvyScript supports auto casting between the most important Java types
and IvyScript types. This means that you no longer have to use the
toXyz() methods on your IvyScript values. Instead you can directly
assign IvyScript types to Java types and vice versa. This also holds for
lists (IvyScript) and arrays (Java).

The following auto-casting rules are supported by IvyScript
(bidirectional):

.. table:: Auto casting rules

   +--------------------------+-----+----------------------+
   | Java type                |     | Ivy type             |
   +==========================+=====+======================+
   | JDBC (SQL) ``Timestamp`` | <-> | Ivy ``DateTime``     |
   +--------------------------+-----+----------------------+
   | JDBC (SQL) ``Date``      | <-> | Ivy ``Date``         |
   +--------------------------+-----+----------------------+
   | JDBC (SQL) ``Time``      | <-> | Ivy ``Time``         |
   +--------------------------+-----+----------------------+
   | Java ``Date``            | <-> | Ivy ``DateTime``     |
   +--------------------------+-----+----------------------+
   | Java ``Date``            | <-> | Ivy ``Date``         |
   +--------------------------+-----+----------------------+
   | Java ``Date``            | <-> | Ivy ``Time``         |
   +--------------------------+-----+----------------------+
   | ``byte[]``               | <-> | Ivy ``Binary``       |
   +--------------------------+-----+----------------------+
   | ``aType[]``              | <-> | Ivy ``List<aType>>`` |
   +--------------------------+-----+----------------------+
