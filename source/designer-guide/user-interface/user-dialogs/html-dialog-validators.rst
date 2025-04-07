Validators
----------

The JSF core framework provides several basic validators that can be
used to validate the entered values in an input form.

-  ``validateDoubleRange``
-  ``validateLength``
-  ``validateLongRange``
-  ``validateRegex``
-  ``validateRequired``

An example code fragment from an input form:

::

               <p:inputText value="#{data.zipCode}" id="ZipCode" required="true">
                   <f:convertNumber integerOnly="true" groupingUsed="false"/>
                   <f:validateLength minimum="4" maximum="5"/>
               </p:inputText>     


.. _html-dialog-client-side-validation:

Client Side Validation
^^^^^^^^^^^^^^^^^^^^^^

In some cases, it makes sense to perform the validation of the entered values
before they are sent to the server (e.g., in an :ref:`offline-dialogs`). For this
reason, Primefaces provides a `client side validation
<http://www.primefaces.org/showcase/ui/csv/basic.xhtml>`__ framework.
Client-side validation is an addition to the JSF validators. It can give instant
feedback - even while typing - to the user. Since the standard JSF validators
remain active, the data is also validated on the server after the form has
passed client-side validation and is submitted.

Example code fragment from an input form:

::

               <p:inputText value="#{data.zipCode}" id="ZipCode" required="true">
                   <f:convertNumber integerOnly="true" groupingUsed="false"/>
                   <f:validateLength minimum="4" maximum="5"/>
                   <p:clientValidator event="keyup" />
                   <p:clientValidator event="blur" />
               </p:inputText>     
               <p:message for="ZipCode" display="text" showDetail="true" />
               
               <p:commandButton actionListener="#{logic.close}" value="Proceed" validateClient="true" icon="pi pi-check"  />
           

.. tip::

   It is useful to add the client validators to the desired input field and also
   to trigger client-side validation on the submit button. This way, you make
   sure that client side validation is performed during field modification, but
   also if the user tries to submit the form without any modification.

   To provide good, instant feedback, a message element dedicated to the input
   field might be quite helpful.
