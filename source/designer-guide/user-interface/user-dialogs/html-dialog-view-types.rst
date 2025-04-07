HTML Dialog View Types
----------------------

An HTML Dialog is either a page or a component. Both are complete HTML Dialogs.
Both have their own model (data class), view, and controller (logic). This
concept allows to build component-oriented UI design.

.. note::

   The templates for page and component are configured in the
   :ref:`html-dialog-preferences`.

HTML Dialog Page
^^^^^^^^^^^^^^^^

An HTML Dialog page represents a full page that is displayed in the web browser.
Therefore a page can be opened by a :ref:`process-element-user-dialog`.


.. _html-dialog-layouts:

HTML Dialog Layouts
^^^^^^^^^^^^^^^^^^^

An HTML Dialog Page uses an HTML Dialog Layout. An HTML Dialog Layout is the
concept of a master page that defines a common layout for several similar
dialogs. An HTML Dialog Page references a layout and implements defined parts of
it. For example, the layout provides the header- and footer-area whereas the
content area is individually implemented on each dialog.

Axon Ivy is delivered with a set of predefined layouts. The layout (together
with the view type) is chosen in the :ref:`New User Dialog Wizard
<user-dialog-new-wizard-page-1>`.

For more information about templating, have a look at the official JSF
documentation.


Custom HTML Dialog Layouts
^^^^^^^^^^^^^^^^^^^^^^^^^^

Axon Ivy is not limited to the usage of the built-in HTML Dialog Layouts. Custom
layouts can be added with little effort.

To add a custom layout - which is a normal XHTML file - it needs to be stored in
the :file:`webContent` folder of the project. In doing so, the custom layout can
now be referenced as a layout inside an HTML Dialog.

To make the custom layout show up in the :ref:`New User Dialog Wizard
<user-dialog-new-wizard-page-1>` (for selection of the view type), it has to be
stored in the folder ``webContent/layouts`` of the project.

The folder structure of ``webContent/layouts`` should follow the
following contract:

-  ``webContent/layouts/[MyTemplateName].xhtml``
-  ``webContent/layouts/[A sub folder]/[for additional template content]``

.. note::

    A layout can be located anywhere in the :file:`webContent` folder, but as
    mentioned before we recommend storing it in the :file:`webContent/layouts`
    folder. 
    
    Please don't store it into the :file:`webContent/view` folder. This location
    is intended for :ref:`static-jsf-pages` - pages that can be called directly.


.. _html-dialog-component:

HTML Dialog Component
^^^^^^^^^^^^^^^^^^^^^

A component can be embedded into other HTML dialogs or in another component.

View Definition
~~~~~~~~~~~~~~~

The view consists of two parts: an interface, and the implementation. The
interface is constituted by a ``<cc:interface componentType="IvyComponent">``
tag and is followed by an optional list of component attributes. The
implementation part starts with a ``<cc:implementation>`` tag and the component
attributes can be accessed with the expression ``cc.attrs.attributeName``

The following code fragment defines an example HTML Dialog component:

::

           <cc:interface componentType="IvyComponent">
               <cc:attribute name="caption" />
           </cc:interface>
           <cc:implementation>
               <p:fieldset legend="Address Component">
                   <h:outputLabel value="#{cc.attrs.caption}" />
                   <h:panelGrid columns="2">
                       <p:outputLabel value="Street" for="street" />
                       <p:outputLabel value="Country" for="country" />
                       <p:inputText value="#{data.address.street}" id="street" />
                       <p:inputText value="#{data.address.country}" id="country" />
                   </h:panelGrid>
               </p:fieldset>
           </cc:implementation>
           

Usage
~~~~~

A component is inserted with the ``<ic:``-tag. E.g.
``<ic:my.namespace.ComponentName ... />``.

.. tip::

   In the **HTML Dialog Editor** you have tool support for
   inserting components. You can select one from the auto completion popup
   list and you can define required attributes in the properties view.

Start Method
~~~~~~~~~~~~

Optionally, you can define the start method that is used to start the embedded
component with the attribute ``startMethod``. If you do not define the start
method, then a default start method will be used. Parameters of the start method
can be defined by adding them as named attributes. Parameters are mapped by
name, i.e., an attribute of the tag will be mapped to the start method parameter
with the same name. You can set the component attributes that you defined in the
interface of the component by simply adding them as attributes of the tag, too.

.. note::

   You cannot override start methods. So do not use multiple start
   methods with the same name but different parameter lists.

See the following code fragment that inserts an HTML Dialog component. We use a
start method ``start(data.person.BillingAddress:address)``. The current value of
the data class property ``billingAddress`` is used as a parameter for the start
method and the component attribute ``caption`` will be set to the value "Billing
Address"

::

       <h:panelGrid columns="2">
           <ic:ch.ivyteam.htmldialog.demo.component.AddressComponent
               startMethod="start" address="#{data.person.billingAddress}"
               caption="Billing Address">
           </ic:ch.ivyteam.htmldialog.demo.component.AddressComponent>
       </h:panelGrid>
