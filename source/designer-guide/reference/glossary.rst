Glossary
========

This chapter provides an alphabetized glossary for specialized
expressions and terms that are employed in this book.

Application
   On the Axon Ivy Engine one or more Applications can exist. The
   Application defines the container wherein the :ref:`Process Models <glossar-process-model>` can be deployed.

   Also :Ref:`Users <glossar-user>` and :ref:`Roles <glossar-role>`
   are defined and :ref:`Tasks <glossar-task>` and
   :ref:`Cases <glossar-case>` are stored in an Application.

   See also section :ref:`Application <application>`.

.. _glossar-case:

Case
   A Case is one concrete instance of a
   :ref:`Process <glossar-process>`. It must not necessarily run
   through all :ref:`Steps <glossar-step>` of a
   :ref:`Process <glossar-process>`. A
   :ref:`Process <glossar-process>` may define a different handling
   for different Cases depending on the information of a Case. For
   example by using the :ref:`Alternative Element <process-element-alternative>`.

   A Case holds the information used to carry out the
   :ref:`Process <glossar-process>`. This is on the one hand
   information about the Case like the current position in the
   :ref:`Process <glossar-process>`. On the other hand this is
   information collected during the Case, which is passed from one
   :ref:`Step <glossar-step>` to the next in the form of the :ref:`Process Data <glossar-process-data>`

.. _glossar-connector:

Connector
   A Connector connects two :ref:`Steps <glossar-step>` of a
   :ref:`Process <glossar-process>`. This defines the sequence of
   these two steps.

Form Field
   A Form Field is a JSF code snippet which serves content for a
   specific data class field type (e.g., a Label and a Datepicker for a
   Date). The :ref:`New User Dialog Wizard <user-dialog-new-wizard>`
   create forms with Form Fields.

HTML Dialog
   A :ref:`HTML Dialog <html-dialogs>` is an implementation of a
   :ref:`User Dialog <user-dialogs>`. The HTML Dialog is implemented with
   (HTML/JSF).

Layout
   A Layout contains the main structure of an HTML page (e.g., a header,
   content and footer section). For :ref:`Web Pages <user-interface-web-page>` the
   layouts are defined in the :ref:`CMS <cms>`. For :ref:`HTML Dialogs <html-dialogs>`
   the layouts are defined in the
   webContent folder.

.. _glossar-process:

Process
   A Process is an abstract description how a group of
   :ref:`Cases <glossar-case>` will be handled. It consists of
   :ref:`Process Elements <glossar-process-elements>` connected with
   each other. Every time a Process is started, a
   :ref:`Case <glossar-case>` and a :ref:`Task <glossar-task>` is
   created.

.. _glossar-process-data:

Process Data
   The Process Data is the data passed from one
   :ref:`Step <glossar-step>` to the next. Its represented by a data
   class used for the whole process. Even though every
   :ref:`Step <glossar-step>` can create a new instance of this data
   class to be passed to the next :ref:`Step <glossar-step>` it will
   always be an instance of the same data class.

.. _glossar-process-elements:

Process Element
   Process Elements are the bricks a process is built of. Ordered with
   :ref:`Connectors <glossar-connector>` they become the
   :ref:`Step <glossar-step>` of a
   :ref:`Process <glossar-process>`.

   There are 3 groups of process elements.

   -  Activities do something. Like running a script or let somebody
      else do something for example by showing a :ref:`user-dialogs`.

   -  Gateways structure a :ref:`Process <glossar-process>`. For
      example a
      :ref:`Alternative <process-element-alternative>` decides
      which way a :ref:`Case <glossar-case>` runs through the
      :ref:`Process <glossar-process>`.

   -  Events are notifications of things that happen outside the
      process.

   The chapter :ref:`process-elements`
   describes all the Process Elements available.

.. _glossar-process-model:

Process Model
   A Process Model on the Engine corresponds to an Axon Ivy project on
   the Designer. The difference is that a Process Model may hold
   multiple different versions of the same Axon Ivy project. These are
   called :ref:`Process Model Version <glossar-process-model-version>`.

   See also section :ref:`Process Model <process-model>` in
   chapter Deployment.

.. _glossar-process-model-version:

Process Model Version
   A :ref:`Process Model <glossar-process-model>` can have multiple
   versions called Process Model Versions. These versions allow to
   change an Axon Ivy project without worrying about the compatibility
   of currently running :ref:`Cases <glossar-case>` on the Engine.

   See also section :ref:`Process Model Version <process-model-version>` in chapter
   Deployment.

.. _glossar-role:

Role
   A :ref:`User <glossar-user>` has one or multiple Roles which define
   what the user is allowed to do.

Signature
   In computer programming, especially object-oriented programming, a
   method is commonly identified by its unique method signature. This
   usually includes the method name, and the number, types and order of
   its parameters, but usually excludes the return type(s) of the
   method.

   Within *Axon Ivy*, signatures act as unique identifiers for specific
   start elements (e.g., method starts, request starts, trigger starts,
   call sub starts), within the same process, only one element with the
   same signature may exist. The same holds true for signatures of start
   methods and events on a User Dialog interface.

.. _glossar-step:

Step
   A :ref:`Process Element <glossar-process-elements>` placed in a
   :ref:`Process <glossar-process>` becomes a Step of this
   :ref:`Process <glossar-process>`. The
   :ref:`Connectors <glossar-connector>` define the order of the Steps
   in a :ref:`Process <glossar-process>`.

.. _glossar-task:

Task
   A Task is a unit of work which is indivisible. It has to be carried
   out by one user in one piece. If anything goes wrong during the
   execution of a task, we must return to the beginning of the task.

   It's not possible to work on a :ref:`Case <glossar-case>` without a
   Task. Every time a new :ref:`Case <glossar-case>` is started a Task
   will be created. While working on a :ref:`Case <glossar-case>` /
   Task new Tasks can be created. This allows to interrupt the work on a
   :ref:`Case <glossar-case>` and to hand it over to another user if
   necessary.

   A Task consists of one or multiple :ref:`Steps <glossar-step>`. It
   begins for example with a
   :ref:`Request Start <process-element-start-request>` or a
   :ref:`Task Switch <process-element-task-switch-event>` Element. And ends for
   example with the next
   :ref:`Task Switch <process-element-task-switch-event>` Element or at the
   :ref:`Process End <process-element-process-end>`.

   Task can be assigned to a specific User, a Role or to Everybody.

.. _glossar-user:

User
   A User is a person interacting with a :ref:`Case <glossar-case>`.
   The user is identified by a unique user name.

   If a User is not identified, we speak of an anonymous User.

User Dialog
   A :ref:`user-dialogs` is a concept of an User
   Interface. User Dialogs can be implemented as HTML Dialog (HTML/JSF).

View Type
   A View Type defines the default content of a :ref:`user-dialogs` View.
   Axon Ivy has predefined View Types, i.e., Page and Component.
