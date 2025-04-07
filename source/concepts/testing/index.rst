.. _testing:

Testing
=======

Writing test code can sometimes be tedious and time consuming, however, in the
long run these tests make your life a lot easier. Think about the following points:

- Tests can make the **functionality of a software reliable**

- Through tests **quality** can be maintained

- **Repetitive tasks** can be reduced to a minimum. Let the computer do it!

- Ensure that your software **does what it supposed to do** (e.g., after a code
  change or even a platform update).

Writing good software without tests is nearly impossible, and we want to make it
as easy as possible for you to write tests for your |ivy| project. Let's
get started!

.. tip::

  The following guide is based on a 
  :link-url:`demo project <build-examples-test-project>` and uses the name ``crm`` for the project to be
  tested and the two testing projects ``crmTests`` for the
  :ref:`process-<process-testing>` and :ref:`unit-testing<unit-testing>` as well
  as ``crmIntegrationTests`` for the :ref:`web-testing<web-testing>`. 
  
  Since this documentation only shows how to setup a test project and perform
  simple tests, you should take a closer look at the demo project.

.. toctree::
   :maxdepth: 1

   process-testing
   unit-testing
   web-testing
