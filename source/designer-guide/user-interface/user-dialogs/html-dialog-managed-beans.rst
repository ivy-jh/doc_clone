.. _html-dialog-managed-beans:

Managed Beans
-------------

In HTML Dialogs it is possible to communicate with normal Java objects
by using *ManagedBeans*. Use the following annotations to define the
lifecycle scope of the managed bean:

-  ``@ApplicationScoped`` - the bean instance is created at creation of the
   application or at the engine startup and destroyed when the
   application is either deleted or the engine shuts down.

-  ``@SessionScoped`` - the bean lives for the whole duration of the session

-  ``@RequestScoped`` - an instance of the bean is created for each new
   request and thrown away after the response has been sent. This is the
   default scope that will be used when no scope is set specifically.

.. note::

   JSF 2.0 introduced an additional scope @ViewScoped and offers the
   possibility to define custom scopes. This is basically also supported
   in Axon Ivy, but it is recommended to use it with care since it might
   not behave as expected.

In the :ref:`HTMLDialogDemo Project <importing-demo-projects>` that is included in
the Axon Ivy Designer you find an example.

Bean Validation (JSR 303)
^^^^^^^^^^^^^^^^^^^^^^^^^ 

The *JSR 303* is a specification that defines a metadata model for bean
validation. The fields of the JavaBean classes, that are used for
storing the data, are annotated to describe the constraints and their
validation. Experienced programmers can use JSR 303 annotations in
Axon Ivy projects. The validation information will then be considered by
HTML Dialogs when the field of the class is bound to a widget. There is
no validation information given in the \*.xhtml file of the HTML Dialog
itself. However, the HTML Dialog uses the annotations of the fields to
validate the user input.

All annotations defined in the package `javax.validation.constraints` are
supported. For the validation messages you can use Axon Ivy macros to get the
message content from the :ref:`cms`. For example:

-  ``@NotNull`` means that a value is required

-  ``@Size`` restricts the length of a string or array or the size of a
   collection or map

-  ``@Max`` restricts the maximum allowed value

-  ``@Min`` restricts the minimum allowed value

-  ``@Pattern`` restricts a string to a given regular expression

-  ``@Digits`` restricts the maximum number of digits of the integer and
   faction part

-  ``@Future`` restricts a date to the dates in the future

-  ``@Past`` restricts a date to the dates in the past

::

   @SessionScoped 
   public class Person 
   {
       @Size(min=3, max=10, message="<%=ivy.cms.co(\"/ch.ivyteam.htmldialog.demo/BeanValidationDemo/between3And10Characters\")%>")
       @NotNull(message="<%=ivy.cms.co(\"/ch.ivyteam.htmldialog.demo/BeanValidationDemo/notnull\")%>")
       private String name;
       
       @Pattern(regexp="[1-9][0-9]{2}\\.[0-9]{2}\\.[1-8]([0-8][0-9]|9[012])\\.[0-9]{3}", message="<%=ivy.cms.co(\"/ch.ivyteam.htmldialog.demo/BeanValidationDemo/socialSecurityNumber\")%>")
       @NotNull(message="<%=ivy.cms.co(\"/ch.ivyteam.htmldialog.demo/BeanValidationDemo/notnull\")%>")
       private String socialSecurityNumber;

There will always be validation requirements for which these standard
annotation will not suffice. For these cases it is possible to create
your own annotation. You find an example in the :ref:`HTMLDialogDemo Project <importing-demo-projects>`.

::

   public class Person 
   {
       @LicensePlate(message="<%=ivy.cms.co(\"/ch.ivyteam.htmldialog.demo/BeanValidationDemo/licensePlate\")%>")
       private String vehicleLicense;

::

   // re-use other existing constraints:
   @NotNull
   @Size(min=4, max=20)
   @UpperCase // custom constraint in same package
   @StartsWith(prefix="ZG") // custom constraint in same package

   //only show the validation message from this annotation and not from it's re-used types:
   @ReportAsSingleViolation 

   @Target( { METHOD, FIELD, ANNOTATION_TYPE })
   @Retention(RUNTIME)
   @Constraint(validatedBy = {})
   @Documented
   public @interface LicensePlate {
       String message() default "Field does not contain a valid license plate";
       Class<?>[] groups() default {};
       public abstract Class<? extends Payload>[] payload() default {};
   }
