Converters
----------

Converters are used to convert number or date/time values for string
representation and vice versa. If you want to display a ``Number`` or
``Date``/``DateTime`` process data attribute well-formatted in an input
widget then use the basic converters provided by the JSF core framework:
**convertNumber** and **convertDateTime**.

See this code fragment from an input form:

::

   <p:calendar id="Birthday" value="#{data.birthday}" navigator="true" 
           required="true" pattern="dd.MM.yyyy">
       <f:convertDateTime pattern="dd.MM.yyyy" />
   </p:calendar>


IvyListItem Converter
^^^^^^^^^^^^^^^^^^^^^

If you use Primeface list components (e.g. SelectOneMenu, SelectOneListbox, Picklist..)
there is a default-list converter from us ``ivy.ListItem``, which helps you to convert 
your List of Objects. The Converter will work with the most common Datatypes as well.

Example:

::

  <p:selectOneMenu value="#{data.converter.person}" converter="ivy.ListItem">
    <f:selectItems value="#{data.converter.listOfPerson}" 
      var="person" itemLabel="#{person.name}" itemValue="#{person}" />
  </p:selectOneMenu>


Custom Faces Converters
^^^^^^^^^^^^^^^^^^^^^^^

Custom Faces Converters can be implemented as a Java class with a
specific ``FacesConverter`` annotation and then be used in your Axon Ivy
project.

Example:

::

       @FacesConverter("MyCustomFacesConverter")
       public class MyCustomFacesConverter implements Converter
