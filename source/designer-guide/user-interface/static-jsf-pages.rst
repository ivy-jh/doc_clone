.. _static-jsf-pages:

Static JSF Pages
================

It is possible to use JSF (XHTML) pages outside of a normal :ref:`user-dialogs`.
If you want such a static JSF page, you can create a new subfolder :file:`view`
inside the :file:`webContent` directory. The concept is mostly the same as
described in :ref:`html-dialogs`. Those pages run on an application and process
model but without a case or task.

Because these pages are outside of a normal :ref:`user-dialogs` structure, it is
not possible to access any Axon Ivy data or logic classes. If you want logic and
data you need to implement **ManagedBeans** (see
:ref:`html-dialog-managed-beans`) which will provide this for you.

.. warning::

   It is not possible to use :ref:`html-dialog-component` inside of static JSF
   pages. Even if you use a static JSF page as the workflow end page, it is not
   possible to access the case and task context.


Access Static Pages
-------------------

**URL**

To access these pages with a browser you need to call
``http://<servername>:<port>/<application>/faces/view/<process model>/<xhtml
file in webContent/view>``. Assuming that you have a XHTML page with the name
test.xhtml in your :file:`webContent/view` folder, an <application name> App and
a <processmodel> PM, you can call the URL
``http://localhost:8080/App/faces/view/PM/test.xhtml`` to get your static
JSF page. 

.. note::
   
   Please note that any page located within the folder :file:`webContent/view`
   is accessible via this static URL. So you should only have pages in this location
   which are fully functional (i.e., no template pages), and you should secure them
   via a login page.


**EndPage**

If you want to call a static JSF page from an Axon Ivy process, you can
implement a :ref:`End Page <process-element-end-page>`, :ref:`Task Switch
Gateway <process-element-task-switch-gateway>` or :ref:`Task Switch Event
<process-element-task-switch-event>` element and choose the XHTML file as its
end page. See the related example in the :ref:`HTMLDialogDemos
<importing-demo-projects>`.
