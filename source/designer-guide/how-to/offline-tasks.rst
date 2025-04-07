.. _offline-tasks:

Offline Tasks
=============

Offline tasks are designed for use on a mobile device without connection
to the |ivy-engine|. Typically the task data and the task forms are
loaded during the synchronization with the |ivy-engine| and then
handled locally by an app on a mobile device (e.g., a smartphone or a
tablet). When the form is completed, the mobile app will transfer the
entered form data to the server as soon as the connection to the
workflow server is back again. In turn, this will resume the task and
continue the process execution.


Offline Task in a Process
-------------------------

An Offline Task is generated, when the process engine executes a
:ref:`process-element-user-task` whereon an Offline Dialog is configured.

The User Task element provides a different task handling than normal
task switches do. On a User Task, when the form data (the actual dialog
page) is requested, the corresponding task remains in state *suspended*.
The task state will be changed to *resumed* when the form data is
submitted. Compared to this, a normal Task must be resumed first and
after that, an Html Dialog element that follows in process flow, will
return the form data.

.. table:: Comparison of the execution sequence
   :widths: 20 40 40 

   +-----------------------+-----------------------+-----------------------+
   | Action                | User Task element     | Task Switch element   |
   |                       |                       | followed by Html      |
   |                       |                       | Dialog element        |
   +=======================+=======================+=======================+
   | Task picked up from   | -  Task state remains | -  Task state changes |
   | task list             |    unchanged.         |    to resumed.        |
   |                       |                       |                       |
   |                       | -  Dialog page from   | -  Process flow       |
   |                       |    configured dialog  |    continues to Html  |
   |                       |    is returned.       |    Dialog element.    |
   |                       |                       |    Dialog page from   |
   |                       |                       |    configured dialog  |
   |                       |                       |    is returned.       |
   +-----------------------+-----------------------+-----------------------+
   | Form data submitted   | -  Task state changes | -  Form data is       |
   |                       |    to resumed.        |    mapped to dialog   |
   |                       |                       |    data.              |
   |                       | -  Form data is       |                       |
   |                       |    mapped to dialog   | -  Dialog is closed,  |
   |                       |    data.              |    dialog data is     |
   |                       |                       |    mapped to process  |
   |                       | -  Dialog is closed,  |    data.              |
   |                       |    dialog data is     |                       |
   |                       |    mapped to process  | -  Process execution  |
   |                       |    data.              |    continues in       |
   |                       |                       |    context of the     |
   |                       | -  Process execution  |    workflow user that |
   |                       |    continues in       |    resumed the task.  |
   |                       |    context of the     |                       |
   |                       |    workflow user that |                       |
   |                       |    submitted the      |                       |
   |                       |    form.              |                       |
   +-----------------------+-----------------------+-----------------------+

.. tip::

   Offline Tasks can also be processed using a normal web browser as
   client. From a user's perspective they can be processed almost like
   normal tasks.

Because of the different task handling of a User Task element, the
session can be interrupted/terminated after the form data was loaded.
Then the form can be processed offline. After reestablishing the
connection and creating a new session, the form data can be submitted.
This would not work with normal tasks, since they are reset, as soon as
the corresponding session (the one that resumed the task) expires.

.. note::

   An offline aware application must manage the loading of the form data
   for required tasks, the presentation of the forms to the user during
   offline stages and the submission of the form data when the
   connection to the engine is established again. The |ivy| mobile app has
   full support for offline tasks.


.. warning::

   Because the processing of an Offline Task may happen in parallel by
   several users, the task assignment should be set with caution. The
   form-submission of the first user will resume the task and continue
   the process. Subsequent form-submissions - from any user - will not
   be processed but responded with an error message.

Process elements that follow a User Task element will be executed in the
context of the same task. An error during the execution of these
elements will result as an error response to the form submission and the
whole user task is set back to suspended.

.. tip::

   Placing an Html Dialog element after an (Offline) User Task element
   is not a good idea, since it will not be handled correctly by an app
   that submitted the offline form. Generally it's best practice to
   place a task switch (Task Switch element of another User Task) as
   soon as possible after a User Task element.


.. _offline-dialogs:

Offline Dialogs
---------------

An Offline Dialog is a special kind of HTML Dialog that warrants to be
suitable for offline usage.

|ivy| treats Offline Dialogs as separate view technology. Only when a User
Task element is configured to use an Offline Dialog, it will generate
Offline Tasks. Otherwise, normal tasks will be generated. From a
technical point of view, an Offline Dialog is the same as a normal HTML
Dialog. They both are User Dialogs built on top of the JSF technology.

Even though there is no technical restriction - like a validation or
similar - an Offline Dialog must omit any features that requires an
active server connection before form submission. So, not all JSF
features can be used. It's in the responsibility of the dialog developer
to ensure the offline capability when developing an Offline Dialog.

Restrictions for the design of offline capable dialogs:

-  The view should not rely on server side state e.g., session
   attributes, because it is executed solely on the client.

-  The dialog data fields defined as persistent are held in the client
   view state. So, these fields, together with fields submitted in the
   form, are available in the dialog logic (methods and events). All
   other data fields are only available in the start method to
   initialize the dialog. Anywhere else in the dialog logic, they will
   be set to null.

-  Owed to the offline capability, Ajax requests to the server are not
   possible. E.g., auto complete, lazy loading

-  The entered data should be validated **before** form submission
   (:ref:`html-dialog-client-side-validation`). If
   only server side validation is performed, the user will get a late
   feedback, expressed as synchronization error when switching from
   offline to online.


.. note::

   The layout and the styling of an offline capable dialog should
   consider the client device where it will run. Most probably it will
   be embedded in an mobile app on a device with a small touch-screen.

.. tip::

   To avoid Ajax on form submission, a p:commandButton can be configured
   with the attribute ajax="false":

   ::

          <p:commandButton value="Proceed" actionListener="#{logic.close}" ajax="false" />    

Geo Location
------------

The mobile app sends the current position of the mobile device to the
server. This information is then stored in a location services that are
available on the user that has worked with the mobile app and the tasks
that have been worked on the mobile app.

Get latest position of a task:

.. code:: java

   import ch.ivyteam.ivy.location.GeoPosition;
   
   GeoPosition taskPosition = ivy.task.locations().search().findLatest().getPosition();

Get latest position of a user:

.. code:: java 

   import ch.ivyteam.ivy.location.GeoPosition;
   
   GeoPosition userPosition = ivy.session.getSessionUser().locations().search().findLatest().getPosition();

The location service can also be used to store additional locations:

.. code:: java 

   import ch.ivyteam.ivy.location.GeoPosition;
   import ch.ivyteam.ivy.location.ILocation;
   
   ivy.session.getSessionUser()
     .locations()
     .add(ILocation
         .create(GeoPosition.inDegrees(47.171573, 8.516835))
         .withType("User Home")
         .withNote("My Home is my Castle")
     );

More information can be found in the package
:public-api:`ch.ivyteam.ivy.location </ch/ivyteam/ivy/location/package-summary.html>`.
It defines the location service and types to create, store and
manipulate location information and geo-positions.
