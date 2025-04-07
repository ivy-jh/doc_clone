.. _html-dialogs:

HTML Dialogs
------------

An HTML Dialog (in the following abbreviated as HD) is the |ivy| way to
implement a User Dialog Component. HDs use the Java Server Faces (JSF)
technology.

Therefore, the view of an HD is defined by an XHTML document displayed in a web
browser.


PrimeFaces JSF Component Library
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

|ivy| bundles the JSF component library 
`PrimeFaces <http://primefaces.org/>`__, an open source JSF component library
developed by Prime Teknoloji. It provides a collection of mostly visual
components (widgets). JSF programmers use these in addition to the small set of
basic components shipped with the core JSF platform. Refer to the `PrimeFaces
Showcase <http://www.primefaces.org/showcase/>`__ to learn about PrimeFaces. 
Find detailed PrimeFaces widget API documentation in the `PrimeFaces VDL doc
<http://www.primefaces.org/vdldoc/>`__.

.. tip::

   The **HTML Dialog Editor** supports PrimeFaces during design time. You can
   profit from code completion support, tag validation and the property view
   offering structured properties.

The elements of the PrimeFaces library are added to your XHTML page by the
``<p:>`` namespace. |ivy| also includes the **primefaces-extension**\ ``<pe:``
widget library.

.. note::

   It is also possible to install and use additional JSF libraries. Copy their
   .jar files into the folder **/webapps/ivy/WEB-INF/lib** of both
   |ivy-designer| and |ivy-engine|. Then, you have to add a namespace attribute
   **xmlns:xx** on your html pages to use the widgets.


HTML Dialog Data Binding and Event Mapping
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

An HD follows the model-view-controller pattern of the |ivy|
:ref:`user-dialog-concept`. Therefore, a HD consists of 

- a **XHTML dialog** (the view) 
- a **data class** (the model) whose data fields you can bind to widget
  properties of the view. To define such a binding, |ivy| provides the special
  object **data**.
- a series of UI processes (the controller), which you can map to events on the 
  view like mouse clicks. To define such an event mapping, |ivy| provides the 
  keyword **logic** to call an event process or a method process in the logic.

Look at the following small code sample of a form with a mapped data
attribute on an input text field and a button with a bound event
process:

::

     <h:body>
       <h3>My JSF Form</h>
       <h:form id="myForm">
           <p:outputLabel value="#{ivy.cms.co('/labels/street')}" for="street" />
           <p:inputText value="#{data.address.street}" id="street" />
           <p:commandButton value="#{ivy.cms.co('/labels/submit')}" actionListener="#{logic.submit}"/>
       </h:form>
     </h:body>
       

Data Class Auto Initialization
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

|ivy| initializes Data Classes automatically if an HD sets at least one
of their properties.

E.g., if ``data.address`` is ``null``, and a user submits a form with a
value for ``data.address.street``, then a ``data.address`` object is
automatically created.

See also Public API ``ch.ivyteam.ivy.scripting.objects.jsf.el.AutoInitializable``.
