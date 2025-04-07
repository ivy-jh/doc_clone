.. _process-element-pi:

PI (Programming Interface) Activity
===================================

|element| The *Program Interface Activity* element is located in the
*Activity* drawer of the process editor palette.

.. _ivy.processmodels.elements.pi.element:

Element Details
---------------

The Program Interface Activity integrates custom-made software, 
legacy systems, proprietary applications or any other external system through a
Java interface into the process workflow.

Scope
~~~~~~~~~
If you just need to call some Java code within your workflow, 
it's normally preferrable to do this via the :ref:`process-element-script-activity`.

If not only Java code must be called, but process logic, too, 
you are better off with calling a re-usable :ref:`Callable SubProcesses <process-kind-callable>`
that wraps your complex logic.

Furthermore, :ref:`Callable SubProcess Start <process-element-tab-start>` elements
contain an expressive input/output parameter descriptor. This infrastructure
often makes the need for a hand-crafted configuration Editor obsolete.
In addition, these starts can be enriched with an illustrative logo and 
will appear prominently as connectors in the palette if tagged as such.

Still, there might be edge cases where you prefer the programmable element infrastructure.
For instance as you like the style, and already built up knowledge on it while
implementing a :ref:`process-element-program-start` or a :ref:`process-element-wait-program-intermediate-event` bean.



Inscription
---------------

Java Bean Tab
~~~~~~~~~~~~~

On this tab you define the Java class to be executed.

.. figure:: /_images/process-inscription/program-interface-tab-start.png
   :alt: Start tab

   Start tab

Java Class
   Fully qualified name of the Java class that implements the
   :public-api:`IUserProcessExtension </ch/ivyteam/ivy/process/extension/IUserProcessExtension.html>`
   interface. 
   Use the :ref:`new-bean-class-wizard` |add-button| to create a new Java
   source file with an example implementation of the bean class.

Program
   Defines the :ref:`process-element-error-start` element which can handle execution errors.

Timeout
   Defines a timeout for the return call to the Java PI class.
   A timout error can be handled by a catching :ref:`process-element-error-start`.


Configuration Tab
~~~~~~~~~~~~~~~~~

The custom editor UI provided by the implementation of 
:public-api:`IUserProcessExtension </ch/ivyteam/ivy/process/extension/IUserProcessExtension.html>`
allows to configure its execution.

.. figure:: /_images/process-inscription/program-interface-tab-configuration.png
   :alt: Editor Tab

   A custom editor example


Implementation
---------------

To initiate a custom bean implementation for your third party system, 
you start most conveniently by using the :ref:`New Class <new-bean-class-wizard>` |add-button| 
button on the Start Tab.
The wizard will create a minimal sample implementation that works already. 
You can then adjust it to your needs.


API reference
~~~~~~~~~~~~~~~~~~~~

The Program Interface consumes a Java class that implements the
:public-api:`IUserProcessExtension </ch/i`process-element-tab-start`vyteam/ivy/process/extension/IUserProcessExtension.html>`
interface. 
This implementation is responsible for defining the element execution behavior in 
the method ``perform`` of 
:public-api:`IUserProcessExtension </ch/ivyteam/ivy/process/extension/IUserProcessExtension.html>`.
The common way to implement a Program Interface Bean is to extend from 
:public-api:`AbstractUserProcessExtension </ch/ivyteam/ivy/process/extension/impl/AbstractUserProcessExtension.html>`.


Custom configuration
~~~~~~~~~~~~~~~~~~~~

Very likely, your Program Interface Activity implementation will accept configuration parameters
defining the local environment. For instance, a system specific file 
to send to a legacy system. 

We help you with these configurations by providing an accessor for static
element configurations via :public-api:`getConfig() </ch/ivyteam/ivy/process/extension/impl/AbstractUserProcessExtension.html#getConfig()>`.


.. include:: _programEditor.rst
 
Example implementation
~~~~~~~~~~~~~~~~~~~~~~~~~

.. literalinclude:: includes/ErpLoader.java
      :language: java
      :linenos:


.. |element| image:: /_images/process-editor/elements/program-interface.png
.. |add-button| image:: /_images/ui-icons/plus.svg
  :width: 2em
