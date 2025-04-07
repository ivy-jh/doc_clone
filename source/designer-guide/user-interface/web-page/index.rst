.. _user-interface-web-page:

Web Page
========

As an alternative to User Dialogs, you can display Web Pages or other
web resources to the user of an Axon Ivy process application in a
browser to let him or her interact with the executed process.

Such content is embedded within a business process by using end pages for
various elements in a process (:ref:`process-element-end-page`, a
:ref:`process-element-task-switch-event`, or a
:ref:`process-element-task-switch-gateway` element). When the process reaches
such an element, then the defined content is presented to the user.

You are free to use HTML-based content (plain HTML, JSP) or other
resources (such as images, text files, and many more) as long as
they can be displayed in a web browser.

.. warning::

   When you re-use resources like JSP pages in different process
   elements, you need to carefully consider how to integrate the content
   with the process. When you access members of the data class (e.g., in
   the JSP) you must ensure that this member is accessible in all
   processes that use the resource. Furthermore, in Web Page elements
   you need to ensure that
   
   * there is a way to continue with the process, e.g., an out-link, and 
   * this continuation is valid in all use cases of the resource.

.. warning::

   Please bear in mind that web pages can only be used if a single HTTP
   request is available from the client. This means that you *cannot*
   use web pages if at least one of the following conditions apply:

   -  The current request was not triggered by HTTP (e.g., started by an
      Event Bean).

   -  The current task is executed by SYSTEM.

   -  The process is running in a parallel execution section, e.g., after
      a *Split* element.


.. _user-interface-web-page-creating:

Creating and Editing Web Pages From Within the Process
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A web page can be created or accessed directly from the process. Open
the inscription of any page-capable process element. Depending on
whether the page is already defined or not, you will be presented with
either of the two scenarios described below.

|end-page-inscription|

No Page Has Been Specified Yet
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

You can define the Web Page that should be displayed by using one of the
following three methods:

1. Enter the path to an existing page manually. Specify a path to a web content
   file (e.g., ``commonPages/infoPage.html``). Web content paths are always
   specified relative to the ``webContent`` folder of the current project.
   If you enter a path to a non-existing web content resource, then pressing the |open-file| 
   button will create an empty file at the specified location in the
   ``webContent`` folder and open Eclipse's default editor on it.

2. Select an existing page from the :ref:`CMS <CMS>` by using the |browser| button.
   You can select any file, but a ``wrong type`` error will be displayed if the
   selected content object is not suitable as a page.


A Page is Already Specified
^^^^^^^^^^^^^^^^^^^^^^^^^^^

Click on |open-file| to open the specified page with the system's default editor so
that you can edit its contents. You can change the default editor for any file
type by opening *Window/Preferences* and navigating to */General/Editors/File
Associations*.

Alternatively, you can use the |browser| button to select an entirely
different page to be displayed.

You can also edit the specified path manually if you like.


JSP Page
^^^^^^^^

Inside of a JSP page, you can make use of the
:ref:`Environment Variable Ivy <ivyscript-reference-environmentvariable>`.
It is imported and declared as follows:

::

       <%@ page import="ch.ivyteam.ivy.page.engine.jsp.IvyJSP"%>
       <jsp:useBean id="ivy" class="ch.ivyteam.ivy.page.engine.jsp.IvyJSP" scope="session"/>

You can also use the *in* object (i.e., process data) of the process where the
associated process element is located. You can access the process data by using
the ``ivy.html.get()`` method, e.g., 

::

       <%=ivy.cms.co("myUri")"%>
       <%=ivy.html.get("in.myString")%>

Furthermore, you can insert references to content from the :file:`webContent` directory
into your JSP content objects, e.g., 

::

       <jsp:include page="/jspToInclude/include.jsp" />
       <img src="images/myImage.jpg" >



.. _web-page-store:

Web Pages Storage
~~~~~~~~~~~~~~~~~

The page that is displayed is stored in the :file:`webContent` folder
of the project.

Pages in the web content folder can be stored in any hierarchy below the
project's web content folder (it is not allowed to use or reference content that
is stored outside the project's web content folder). You can use any type as
long as it is possible to render it in the user's browser.

.. note::

   Some browsers delegate the displaying of certain file types to plugins and/or
   applications depending on the configuration of the client. Thus, this behavior
   cannot be controlled by Ivy.


.. |end-page-inscription| image:: /_images/process-inscription/process-end-page-tab-end-page.png
.. |open-file| image:: /_images/ui-icons/go-to-source.svg
   :width: 2em
.. |browser| image:: /_images/ui-icons/list-search.svg
   :width: 2em


.. note::

   Web Pages can be accessed without starting a process. This allows you
   to create for example a translated start page with some process start
   links. See also chapter :ref:`display cms content <cms-display-content>`.
