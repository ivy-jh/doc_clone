.. _html-dialog-multiple-views:

HTML Dialog with Multiple Views
-------------------------------

To implement a user interaction that consists of several pages (for example a
wizard), one HTML Dialog can have multiple views (.xhtml files). This allows you
to enclose a complex user interaction in one HTML Dialog and abstract it from
the business process.

How to Add a View
^^^^^^^^^^^^^^^^^

In the :guilabel:`New` menu in the Axon Ivy project tree you find the wizard 
:guilabel:`New HTML Dialog View` to add a view to an HTML Dialog. Just
enter the name of the view and the XHTML file for the view is created
and added to the HTML Dialog. In the Axon Ivy project tree, all view files of
an HTML Dialog are displayed below the main node of that HTML Dialog.

|html-dialog-new-wizard|

How to Switch Views During Runtime
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

If you have created an HTML Dialog with several views you have to
implement the navigation between the views for the user on your own. The
basic solution is a ``commandButton`` with an ``update`` attribute to
load the next view.

You find an example of a multi-view HTML Dialog in the :ref:`HTMLDialogDemos
project <importing-demo-projects>` that is provided
with the Axon Ivy Designer.

::

   <h:form id="myForm">
       <p:panel header="Multi View Demo" id="panel">
           <h3>Payment - Credit Card</h3>
           <p:messages id="msgs"/>
           <h:panelGrid columns="2">
               <p:outputLabel value="Credit Card Number"/>
               <p:inputMask required="true" value="#{data.creditCardNumber}" 
                   id="CreditCardNumber" mask="9999-9999-9999-9999"></p:inputMask>
           </h:panelGrid>
           <p:commandButton value="Next" update="myForm" action="#{logic.nextView('CreditCard')}"/>
       </p:panel>
   </h:form>

.. |html-dialog-new-wizard| image:: /_images/html-dialog/html-dialog-new-view-wizard.png
