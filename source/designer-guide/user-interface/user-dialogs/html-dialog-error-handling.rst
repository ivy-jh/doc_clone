Error Handling
--------------

The exception handling in HTML Dialogs can be customized. Depending on
the request type the customization differs.

.. _user-dialogs-error-pages:

Error Pages
^^^^^^^^^^^^

Error pages inform the user about unexpected errors that occurred during the execution of 
process activities or HTML dialog interactions.

The default error pages are located at ``webapps/ivy/ivy-error-page.xhtml``. You
can inspect them. These pages can be customized to meet the look of your
workflow application and your company's identity. Moreover, you can adjust the
information displayed. The :public-api:`ErrorPageMBean
</ch/ivyteam/ivy/jsf/bean/error/ErrorPageMBean.html>` is accessible within error
pages to provide context information on the error and its engine state. Other
Ivy APIs are not intended to work in case of an error.

Custom error pages have to be registered in the global :ref:`web-xml`.

.. tip:: Keep in mind that error pages and their configuration do not live 
   within the project. The Migration Wizard will copy error pages from the
   old engine to the new engine but only the pages defined in :ref:`web-xml`.
   Furthermore that this properly works the error pages must be self-contained,
   which means they do not include any other :code:`*.xhtml` files or resources
   like css, javascript or images.

Ajax Errors
^^^^^^^^^^^

If an exception occurs in an Ajax-based HTTP request, the configured Primefaces
Ajax exception handlers come into play. The handlers have to be defined
as part of the *\*.xhtml* file. In the standard layouts provided, handlers are
already configured. See ``webContent/layouts/includes/exception.xhtml`` for
details.

::

   <p:ajaxExceptionHandler update="ajaxExceptionDialog" onexception="PF('ajaxExceptionDialog').show();"/>

The above Ajax exception handler will catch every exception of every
type. If an exception occurs, the action in ``onexception`` will be
executed. In this example, a Primefaces dialog will be shown.

::

   <p:dialog id="ajaxExceptionDialog" header="Error" widgetVar="ajaxExceptionDialog" height="400px">              
       <h:outputText value="Error Id: #{errorPage.exceptionId}"/>
       <br/>
       ...
   </p:dialog> 

The ``errorPage`` bean is available within the Ajax exception handling.
Properties like ``exceptionId`` or ``message`` can be used to provide
specific error information to the user.

View Expired Exception
^^^^^^^^^^^^^^^^^^^^^^

If the view or the session of a user expires then there is a possibility to
catch that exception with a specialized ajax exception handler. Instead of
catching all exceptions, you can specify the type of exception to catch.

::

   <p:ajaxExceptionHandler
       type="javax.faces.application.ViewExpiredException" 
       update="viewExpiredExceptionDialog" 
       onexception="PF('viewExpiredExceptionDialog').show();"/>

This handler will only catch exceptions of type
``javax.faces.application.ViewExpiredException``. The exception handler
with the most specific type of exception will be used.

::

   <p:dialog id="viewExpiredExceptionDialog" header="View or Session Expired" widgetVar="viewExpiredExceptionDialog" height="50px">
       <h:outputText value="The view or session has expired."/>
       <br/>
       <h:outputLink value="#{ivy.html.loginRef()}">Please login again.</h:outputLink> 
   </p:dialog>
