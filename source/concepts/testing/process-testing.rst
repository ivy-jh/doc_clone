.. _process-testing:

Process Testing
---------------

At this point you should already know how to create working processes. Because
software tends to evolve over the years and might receive breaking changes, you
should assure its integrity with process tests. As the name implies those tests
are meant to run through your processes and act like a user might interact with
them. By ensuring that the functionality still works the same way and does not
change accidentally, these tests prevent you from introducing bugs and errors in
your processes.

Setup Test Project
~~~~~~~~~~~~~~~~~~

.. |TESTKIND| replace:: ``IvyProcessTest``
.. include:: includes/_test-project-setup.rst

You now have a simple test called ``SampleIvyProcessTest``.

Note a few things at this point:

Line 28:
  The test class is annotated as an :public-api:`@IvyProcessTest
  </ch/ivyteam/ivy/bpm/exec/client/IvyProcessTest.html>`, this enables you to
  run this test as a process tests.

Line 31:
  As you want to test a specific process in this test class, the generated test
  class defines the
  :public-api:`BpmProcess</ch/ivyteam/ivy/bpm/engine/client/element/BpmProcess.html>`
  under test in a constant called ``testee``. The passed in ``String`` argument
  defines the process to run the test against. Replace ``MyProcess`` with a
  process that actually exists in your project under test.
  
Line 35:
  The process under test can be directly started since it has only one start
  element. If your process under test contains multiple start elements you need
  to define the start element to be executed by using the
  :public-api:`BpmElement</ch/ivyteam/ivy/bpm/engine/client/element/BpmElement.html>`
  selector.

Line 34:
  In each test method you have to pass in a
  :public-api:`BpmClient</ch/ivyteam/ivy/bpm/engine/client/BpmClient.html>`.
  This client is supplied by the process testing framework and represents an
  |ivy-engine| that can run and drive your processes along.


Write a Process Test
~~~~~~~~~~~~~~~~~~~~

Now that everything is ready you can start writing your first actual process
test. Let's start by simply testing the following process:

.. figure:: /_images/testing/write-invoice-process.png


Execute a Process
^^^^^^^^^^^^^^^^^

.. literalinclude:: includes/processtesting/processtesting-test-part1.java
    :language: java
    :emphasize-lines: 11, 12, 13, 14, 16, 17, 19
    :linenos:

Now let's have a closer look at the code:

Line 11-14:
  Here you tell your ``BpmClient`` that you want to test and execute your start
  element. After calling the :ref:`execute<process-testing-start>` method the
  ``BpmClient`` drives your process just after the first task.
  
.. note::

  Note that the ``BpmClient`` does not run through the whole process at once but
  runs task by task. It also ignores ``skipTaskList`` flags and stops the
  execution at ``system tasks``.

Line 16-17:
  You have multiple APIs to assert your processes, one of it is the
  :ref:`process-testing-history`. The ``History`` gives you access to the
  executed process elements, in this example we just assert the names of the
  executed elements.

Line 19:
  The :ref:`process-testing-workflow` API gives you access to the ``Case``,
  ``Tasks`` as well as the ``Session`` of your executed process. Use it to fetch
  information about active ``Cases``/``Tasks``, executed ``Tasks`` or the
  ``Session``.

Continue the Process Execution
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

As noted above the ``BpmClient`` does not run through the whole process at once.
This means we now want to continue the current process.

.. literalinclude:: includes/processtesting/processtesting-test-part2.java
    :language: java
    :emphasize-lines: 17, 18
    :linenos:

We introduced two new things in the code above:

Line 17:
  To drive our process along you need to tell your ``BpmClient`` that it should
  just execute any active task. In this case there is only one possible active
  task that can be executed, the task from the ``UserTask`` element called
  ``write invoice``.

Line 18:
  Of course, you cannot just execute a task without declaring an appropriate
  ``Session``. To declare said ``Session`` you can call the
  :ref:`process-testing-as` method and append the desired ``Session``, ``User``
  or ``Role`` that should execute the next task.

If you execute this test then you will face the following error:

.. code:: none

  No mock installed for UserTask 'write invoice' [1720E35BB7789886-f2]
  
To fix this we need to introduce you to two more concepts, mocking elements and
asserting process data.


Mock Dialogs and Assert Data
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Process tests are not meant to assert UI elements such as HTML Dialogs. Because
dialogs are an important data input interface between users and your processes,
you have to mock those inputs. If you want to test the dialogs themselves,refer
to chapter  :ref:`web-testing`.

Let us add a UI mock for the UI of the UserTask 'write invoice' element.

.. literalinclude:: includes/processtesting/processtesting-test-part3.java
    :language: java
    :emphasize-lines: 16, 17, 18, 29, 30
    :linenos:

Line 16:
  Here you are telling the ``BpmClient`` that you are declaring a
  :ref:`process-testing-mock` for an element.

Line 17:
  Here you select the element whose UI you want to mock by its name.

Line 18:
  The HTML Dialog of the UserTask 'write invoice' returns a single value called
  ``total``. So let's mock the UI part to simulate that the user enters a total
  of ``935`` on the UI.

Line 29-30:
  With the :ref:`process-testing-data` API you can assert the process data of
  the executed elements.

Congratulations, you have learned all about the tools and most important APIs to
assert your process continuation. In the next section we will have a closer look
at some of the APIs.


API Reference
~~~~~~~~~~~~~

The following section describes some of the more common API calls you can use.
If you want to see the full functionality of each API you can follow the links
in each subsection to the :public-api:`Public
API</ch/ivyteam/ivy/bpm/engine/client/package-summary.html>`.


.. _process-testing-select:

Select
^^^^^^

There are multiple ways to select processes and elements. The easiest way is to
find them by their
:public-api:`name</ch/ivyteam/ivy/bpm/engine/client/element/BpmProcess.html>`.

.. literalinclude:: includes/processtesting/processtesting-select.java
    :language: java


.. _process-testing-start:

Start
^^^^^

To :public-api:`start</ch/ivyteam/ivy/bpm/engine/client/BpmClient.html#start()>`
an execution, you need to tell the ``BpmClient`` which ``BpmProcess`` or
``BpmElement`` you want to run. To proceed with the execution, either tell the
``BpmClient`` to continue with the previous
:public-api:`execution</ch/ivyteam/ivy/bpm/engine/client/ExecutionResult.html>`
or choose the next desired ``task``. Using a ``task`` is especially useful if
there are multiple active ``tasks`` available.

.. literalinclude:: includes/processtesting/processtesting-start.java
    :language: java

To test callable subprocesses use the ``subProcess`` method instead of the ``process`` method.

.. literalinclude:: includes/processtesting/processtesting-start-sub-process.java
    :language: java

.. _process-testing-as:

As
^^

Most processes require a specific ``user`` or ``role`` to be executed. You can
define them by calling
:public-api:`as</ch/ivyteam/ivy/bpm/engine/client/RequestBuilder.html#as()>`.

.. literalinclude:: includes/processtesting/processtesting-as.java
    :language: java


.. _process-testing-mock:

Mock
^^^^

There are two ways of
:public-api:`mocking</ch/ivyteam/ivy/bpm/engine/client/BpmClient.html#mock()>`
an element. Either you mock the entire element or the UI or call part. If you
mock the entire element nothing configured on the element is tested at all. On
the other hand if you mock the UI or call part of an element its mapping code is
executed and tested. 

If your process runs through an HTML Dialog you always need to mock it.

.. literalinclude:: includes/processtesting/processtesting-mock.java
    :language: java


.. _process-testing-history:

History
^^^^^^^

Use the :public-api:`History</ch/ivyteam/ivy/bpm/engine/client/History.html>` to
assert the executed process elements. You can either access the exact element
objects or elements names.

.. literalinclude:: includes/processtesting/processtesting-history.java
    :language: java


.. _process-testing-workflow:

Workflow
^^^^^^^^

Use the :public-api:`Workflow</ch/ivyteam/ivy/bpm/engine/client/Workflow.html>`
to access and assert the active ``case`` or ``task``. You can filter them by
activator.

.. literalinclude:: includes/processtesting/processtesting-workflow.java
    :language: java


.. _process-testing-data:

Data
^^^^

With the :public-api:`Data</ch/ivyteam/ivy/bpm/engine/client/ProcessData.html>`
API you can assert the process data at different points in your process. You can
get the ``data`` from the last executed element or from any element during
execution. If an element is executed multiple times you can access the ``data``
of each execution in an ordered list.

.. literalinclude:: includes/processtesting/processtesting-data.java
    :language: java
