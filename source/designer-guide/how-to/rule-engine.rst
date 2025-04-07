.. _rule-engine:

Rule Engine
===========

A Rule Engine is basically a software system that maintains and executes
a given set of rules. More specifically, rules in a rule engine are
usually described in a declarative way. Mostly in the notion of
conditions and actions. Or in more developer friendly words, it's a
bunch of if-then statements. For example, let's take a simple rule for
computing the premium for a car insurance:

::

   if owner.livesInDodgyArea then
       if car.price < 50000 
           premium += 100
       else if car.price < 100000 then
           premium += 200
       else 
           premium += 300

   if owner.livesInBumpyStreetConditionArea then 
       if car.type == SPORTSCAR then
           premium += 500
       else if car.type != SUV AND car.type != TRUCK then
           premium += 100;

You can imagine that with this approach you end up pretty soon into the
`Spaghetti-code <https://en.wikipedia.org/wiki/Spaghetti_code>`__
anti-pattern. You have to take care of all the dependencies and
relations between all the facts on your own leading to a forever-growing
if-then statement that is almost impossible to maintain.

In a rule engine, you create simple standalone rules and you let the
rule engine decide what to fire when. The subtlety is that rules can be
written in any order, the engine picks the ones for which the condition
is true, and then evaluates the corresponding actions. So instead of the
massive if statement, you write the following rules:

::

   if owner.livesInDodgyArea AND car.price < 50000 then premium += 100

::

   if owner.livesInDodgyArea AND 50000 < car.price < 100000 then premium += 200  

::

   if owner.livesInDodgyArea AND car.price > 100000 then premium += 300  

::

   if owner.livesInBumpyStreetConditionArea AND car.type == SPORTSCAR then premium += 500

::

   if owner.livesInBumpyStreetConditionArea AND car.type != SUV OR car.type != TRUCK then premium += 100

Because of this simplification it might even be possible for
non-developers to define or configure the rules (a little bit of tool
support helps too).

In short, a rule engine helps you to decouple your production rules from
the REST of the code and makes it much more maintainable for both
developers and domain experts. But remember that everything has its flip
side. Adding a rule engine means adding another level of complexity into
your architecture (you replace plain code with a new system). And as the
size of your rule sets grow, so does the potential impact to the
performance. For more information about rule engines, please refer to
one of the many available resources in the Internet.

.. tip::

   In |ivy|, we integrate the open source rule engine
   `Drools <https://www.drools.org>`__ to give you the flexibility to use
   a rule engine if you want. We wrapped some of the most basic features
   of Drools into our own UI and API. If you need more than that, then
   simply use the normal full blown Drools API.



Decision tables and DRL files
-----------------------------

We support two formats for defining rules: decision tables and rules
written in the Drools Rule Language (DRL). A decision table is like the
name says a table that can contain many rules. The columns usually make
up the variables of the preconditions/actions whereas each row in the
table specifies one rule. Let's see the decision table for our example:

.. table:: Decision table

   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | Pre-Condition                                                                                                                                   |  Action                      |
   |                                                                                                                                                 |                              |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | lives in dodgy area    | price min                   | prices max                  | lives in bumpy street area            | type of car        | addition to basic premium    |
   +========================+=============================+=============================+=======================================+====================+==============================+
   | yes                    | 0                           | 50000                       | no                                    |                    | 100                          |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | yes                    | 50000                       | 100000                      | no                                    |                    | 200                          |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | yes                    | 100000                      |                             | no                                    |                    | 300                          |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | no                     |                             |                             | yes                                   | sports car         | 500                          |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+
   | no                     |                             |                             | yes                                   | sedan              | 100                          |
   +------------------------+-----------------------------+-----------------------------+---------------------------------------+--------------------+------------------------------+

Decision tables are simple to understand and maintain, especially for
domain experts. On the other hand, the more variables and rules you use,
the more your decision table bloats up and makes it hard to maintain.

The Drools Rule Language (DRL) on the other hand is more oriented
towards developers. It is the native rule language of Drools. Let's see
a rule in DRL:

::

   rule "Luxury cars in dodgy areas cost a nice extra premium"

   when
       c: Car( dodgyArea==true, price > 100000 )
   then
       c.premium += 300;    
   end

Use the context menu entry *New*, the menu *File > New* or the tool bar
button *New* to create either a new decision table or a DRL rule file.
The rules will be shown in the project tree below their root folder
*Rules*.


Execute rules
-------------

Before we see how you can use the rule engine to do something, let's
once more make very clear the difference between logic in source code
and using a rule engine. In code you have to explicitly define which
part of the code to call, you are in control and responsibility to do
the right things in the right order. In a rule engine this is different,
you simply tell the rule engine to execute and it does find out itself
which rules apply and which rules to fire.

To run the rule engine you have to use the :public-api:`Public API of the rule
engine </ch/ivyteam/ivy/rule/engine/api/package-summary.html>` to build and
execute rules on data objects. In a script step you can use ``ivy.rules`` and in
a Java class use :public-api:`Rules
</ch/ivyteam/ivy/rule/engine/api/Rules.html>`. First you will need to create a
:public-api:`RuleExecutor </ch/ivyteam/ivy/rule/engine/api/IRuleExecutor.html>`
with all rules.

.. code-block:: java

   // In Java use Rules.create() instead of ivy.rules
   IRuleExecutor ruleExecutor = ivy.rules.create()
      .namespace("my.rule.name.space")
      .executor();


.. tip::

   Use the namespace to group rule files that belong together and use
   the corresponding API to load all rule files of the same namespace
   together. You can also load the rule files from your dependent
   projects. And you can override rules and rules files by having a rule
   or rule file with the same name in the overriding project.

Now, what you need too is an instance of the data model that you used in
the pre-conditions and the actions of your rules. You can either give
the root object of your data or a list of objects.

::

   ruleExecutor.execute(out.myDataForTheRules);

You should now see the result of the actions applied in the data that
you passed into the rule engine before.

.. note::

  To use the rule engine `Drools <https://www.drools.org>`__ directly, you must
  add the *Rule Engine Libraries* to the project's classpath. To do this,
  right-click on the project and select *Properties*. Navigate to *Axon Ivy* >
  *Java* and check *Rule Engine Libraries*.

Demo project
------------

To help you learn how to use the rule engine integration, we created a
small demo project called :ref:`RuleEngineDemos <importing-demo-projects>`.
