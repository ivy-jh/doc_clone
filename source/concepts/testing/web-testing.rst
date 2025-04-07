.. _web-testing:

Web Testing
-----------

Imagine you have just built a workflow app containing multiple user dialogs. Do
you really want to always click through the full process, even if you only
changed a small part of it? However, you should make sure that the functionality
(happy path) of this process is still valid.

**Web Integration Tests** will always follow the same steps and can be
automated.

Setup a Test Project
~~~~~~~~~~~~~~~~~~~~

.. |TESTKIND| replace:: ``IvyWebTest``
.. include:: includes/_test-project-setup.rst

#. Run test

   - Make sure the |ivy-engine| is started with your projects

   - To run this test right-click inside this class -> Run As -> JUnit Test

   - A new **JUnit** View should be opened and the test should be green.


Write a Web Test
~~~~~~~~~~~~~~~~

Let's start by extending our test class generated before with a 
:link-url:`real test implementation <build-examples-web-test-base>`. 
First, we need to start a process. To do this you can use the 
``EngineUrl`` utility from the :ref:`web-tester`. 

This process opens a dialog with two input fields (``firstname`` and
``lastname``) and a ``submit`` button. After submitting, a second dialog with your
input values is displayed.

.. literalinclude:: includes/webtesting/webtesting-test-extend.java
  :language: java

.. figure:: /_images/testing/webtesting-run.gif

.. tip::

  The :ref:`@IvyWebTest <web-tester>` annotation can be configured (e.g to
  select a ``browser`` or to start the test ``headless``).


Select, Do and Check
~~~~~~~~~~~~~~~~~~~~

Now let's take a look at how this test works. Basically, there are three things
you need to know:

- **Select** an element
- **Do an action** on the selected element
- **Check a condition** on the selected element


Select
^^^^^^

To work with a **single element** you need to first select the correct one.
Usually you use the ``By.id`` selector to do this:

.. code:: java

  $(By.id("form:submit")); //Find element by id selector

.. tip::

  To evaluate the real id of an element you can use your browser's **Developer
  Tools**.

  There are many more options to use selectors, e.g you can select multiple
  elements:

  .. code:: java

    $$(By.cssClass("ui-outputlabel")); //Find all <p:outputLabel> elements
  
  Have a look at the :link-url:`demo project <build-examples-web-test-select>`
  to see more options.


Execute an Action
^^^^^^^^^^^^^^^^^

On the selected element you can perform some actions:

.. code:: java

  $(By.id("form:submit")).click();            //click on button
  $(By.id("form:lastname")).clear();          //clear input field
  $(By.id("form:lastname")).sendKeys("Test"); //set input value


Check a Condition
^^^^^^^^^^^^^^^^^

On your selected element you can check certain conditions (e.g is the element
*visible* or contains a specific *value*):

.. code:: java

  $(By.id("form:lastname")).shouldHave(value("Test")); //input field should have value "Test"

.. tip::

  You can check multiple conditions on an item or check a condition before
  performing an action on the item by chaining the method calls:

  .. code:: java

    //button should be enabled before click on it
    $(By.id("form:submit")).shouldBe(enabled).click();
    //<h:outputText> element should be visible and have text "Unit Test"
    $(By.id("form:newCustomer")).shouldBe(visible, text("Unit Test"));

  Have a look at the :link-url:`demo project <build-examples-web-test-condition>`
  to see more options.


Change Application Runtime
~~~~~~~~~~~~~~~~~~~~~~~~~~

For some test cases, you may need to run your web tests with a different user or you need another value for a variable or app configuration. 
In this case the `WebAppFixture` util can help you to achieve this.
Unlike the :ref:`AppFixture <unit-testing-app-fixture>` of :ref:`unit-testing`, the changed values are **not** automatically reset after the test run.
Let's have a look at it:

You can change the current user or log out to an anonymous session:

.. literalinclude:: includes/webtesting/webtesting-test-fixure-login.java
  :language: java
  :emphasize-lines: 2, 4, 8

If you want to change the value of a variable, you can proceed as follows:

.. literalinclude:: includes/webtesting/webtesting-test-fixure-var.java
  :language: java
  :emphasize-lines: 2, 4, 9

Or you can change an app configuration, e.g the URL of a
:ref:`RestClient <rest-clients-configuration>`:

.. literalinclude:: includes/webtesting/webtesting-test-fixure-config.java
  :language: java
  :emphasize-lines: 2, 4, 9


Run Automated
~~~~~~~~~~~~~

Let's have a look at how you can run your web tests fully automated
(:ref:`continuous-integration`). This is especially important if you want fast
feedback on breaking changes done by a team member.


.. _webtesting-maven-build:

Module Build
^^^^^^^^^^^^

Both projects, production and test project, need to be compiled during the same
run. To do this, we need to first setup a Maven module build:

#. Create Maven module

   - Delete projects ``crm`` and ``crmIntegrationTests`` from your |ivy-designer|
     workspace.
   - Open your workspace folder and move both projects into an new folder, e.g
     :file:`compile-test`

   - Create a :file:`pom.xml` file in the :file:`compile-test` folder.

   - Add the following code to the :link-url:`pom.xml
     <build-examples-web-test-pom>` file (ensure the correct **modules** ``crm``
     and ``crmIntegrationTests`` are set):

     .. literalinclude:: includes/webtesting/webtesting-maven-module.xml
        :language: xml

   - Your :link-url:`folder structure <build-examples>` should now look as follows:

     .. code:: none

        workspace/
          compile-test/
            crm/
            crmIntegrationTests/
            pom.xml

#. Run module build in |ivy-designer|

   - In your |ivy-designer| open the **Import** Wizard, then **Existing Maven
     Projects**

   - Select :file:`compile-test/pom.xml` with sub projects (``crm`` and
     ``crmIntegrationTests`` should be visible here) and click **Finish**

   - Right-click on ``compile-test`` -> Run As -> Maven build

   - Set **Goals** to ``clean verify`` and click **Run**

   - This triggers a run that starts and ends with something similar to:

     .. literalinclude:: includes/webtesting/webtesting-maven-run.log
        :language: none

Congratulations, you can now run your tests fully automated with Maven!


Further Resources
~~~~~~~~~~~~~~~~~

If you want to know more about web testing, have a look at the 
:link-url:`second test in our demo project <build-examples-web-test>` or at 
our :link-url:`other demo projects <demos>` and how they are tested.

If you want to learn more about how to build a CI/CD pipeline, take a look at
the **CI/CD videos** in our :dev-url:`Tutorial section </tutorial>`.


Selenium
^^^^^^^^

Selenium is an open source web testing framework. It works across different browsers
and platforms. To communicate with the browser, Selenium provides the **WebDriver**
specification.

In our tests we use the `Selenide <https://selenide.org/>`_ (`GitHub
<https://github.com/selenide/selenide>`_, `API
<https://selenide.gitbooks.io/user-guide/content/en/selenide-api/selenide.html>`_)
framework, which is based on the Selenium WebDriver. If you’re more familiar
with plain Selenium tests the following comparison can give you a quick overview
about the differences and benefits: `Selenide vs Selenium
<https://github.com/selenide/selenide/wiki/Selenide-vs-Selenium>`_. Or you can
simply write your tests with the normal Selenium API by accessing the driver
object:

.. code:: java

  WebDriver driver = WebDriverRunner.getWebDriver();


.. _web-tester:

Web-Tester
^^^^^^^^^^

With the :link-url:`web-tester <webtester>` project we provide the testing
annotation ``@IvyWebTest``. This annotation sets up the browser connection for
you. It can be configured with some parameters:

.. code:: java

  //Default (same as simple @IvyWebTest)
  @IvyWebTest(browser = "firefox", headless = true, reportFolder = "target/selenide/reports")

- **browser**: The browser which should run the test e.g: chrome, firefox, ie,
  phantomjs, htmlunit, safari, opera

- **headless**: Controls if the browser should start with a UI or not.

- **reportFolder**: when a test fails the test framework automatically takes
  screenshots. This folder defines where these screenshots are saved to.
