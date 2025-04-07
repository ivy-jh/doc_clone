.. _adaptive-case-management:

Adaptive Case Management
========================

Classic BPM processes have a clear flow that defines how the process is
executed. Within these strict processes the involved user has limited
possibilities to improve the process while executing. Optimizations and flow
changes often require a long modeling and re-deployment round-trip. Furthermore
the process could get cryptic because every rarely occurring special case has to
be modeled. Therefore, the process does no longer clearly show the most relevant
business paths. Welcome to the world of spaghetti BPM.

Today the user has the need to adapt the process flow during execution. Optional
side tasks are required in addition to the normal process flow or a set of tasks
must be skipped because of a special condition. This brings back the power to
the user who has often more knowledge about the domain and the current context
of the process. For instance an important information could be received from a
phone call, but the workflow system has no knowledge about this analog
information.

Adaptive Implementation
-----------------------

Invoking Optional Processes
~~~~~~~~~~~~~~~~~~~~~~~~~~~

Think about a process where the purchase of an asset must be approved by a line
manager. The line manager may want to ask the requester to provide more details
why the asset is required. Therefore he will add a side task to ask the requester
for clarification. This optional interaction should not be wired into the main
approval process as it obfuscates the most used business path. But it could be
available as an optional side task that the line manager can start and then gets
executed within the current process context.

In |ivy| processes with side steps can be invoked through Triggers or
Signals.

**Triggers**

It is possible to trigger a strictly defined process. Strictly defined means
that the calling process knows the target process as it has to be implemented in
the same or a required project. RequestStart events can be declared as
trigger-able. While the Trigger activity is used to actually trigger such a
start.

So in the request verification front end, a manager could simply trigger the
process to enrich the request with a trigger call activity.

|image0|

|image1|

**Signals**

Most of the time you'd prefer a looser coupling between processes. This is
accomplished with Signals. A process that wants to integrate other processes
simply fires a signal when a certain state within the process is reached.
Multiple other processes in the same application could listen to this signal and
all of them will be executed as soon as the signal is fired. A dependency
between the firing and listening processes is not required.

As example think of an employee that starts to work in a company. When the
employee is registered from HR, other processes can setup the environment for
this employee. An IT responsible will setup a new desktop workstation while an
office administrator will get the personal keys for the employee. To do this
tasks in parallel and loosely coupled signals are the first choice. The IT- and
the office-process could listen to employee entry signals fired by the HR
process.

|image2|

Keeping Loosely Coupled Processes in Same Context
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

A real world agile process execution can touch many different processes. But
still the history and the context must be clear for anyone who is involved in a
task. So the workflow needs to know whether an invoked process belongs to the
invoking case. Or if the invoked process belongs to a new case.

The entity that can glue multiple process cases together is the
:ref:`business-case`. All cases and tasks that belong to the same Business Case
are presented to the user of a workflow screen as related cases. Therefore,
triggerable- and signalable-process start must define whether they belong to the
same Business Case as the invoking process case. This can be done with a simple
configuration on these starts. See :ref:`process-element-signal-start` and
:ref:`Trigger Start <process-element-start-request-trigger-tab>` inscription for
details.

|image3|

You can also use the Public API to attach the current case to an existing
Business Case.

::

   if (in.departement.equals("HR")) // evaluate attachment by runtime conditions
   {
     ivy.case.attachToBusinessCase(in.callerCaseId)
   }

For workflow front end developers we offer an API to list all tasks or cases of
a Business Case. So showing the involved cases and tasks to a workflow user is a
simple implementation. For more details see the Public API of
ch.ivyteam.ivy.workflow.businesscase.IBusinessCase.

::

   ivy.case.getBusinessCase().tasks().allActive(); // get involved tasks that are active
   ivy.case.getBusinessCase().tasks().all(); // get all involved tasks

Aborting Tasks
~~~~~~~~~~~~~~

A long running process could end up with many open tasks that have to be
executed by human users. But eventually the environment of the case changes and
it does no longer make any sense to complete the open tasks. For instance, think
of a car leasing process. If the customer decides shortly before contract
signing that he requires leather seats instead of the furnished ones, the car
will get more expensive. So the whole credit assessment process has to be run
again and thus, the open approval tasks become obsolete.

A :ref:`process-element-user-task` can support
abortion by listening to a signal. The UserTask activity can subscribe
to an abortion signal by adding a :ref:`process-element-signal-boundary-event` 
on it. When the signal that the credit amount of the car changed, is fired from another
process the listening UserTask will be aborted. And the process
continues at the Signal Boundary Event. Typically, after the Signal
Boundary a clean up process follows.

|image4|

Share Data Between Processes
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Often an initial larger process starts by gathering data that is later processed
and enriched. This data is typically business relevant domain data that can be
recognized by domain experts that contribute to the process. Think of a bank
employee who grants credits. The data for his processes could look as follows
when simplified:

.. figure:: /_images/adaptive-case-management/acm-business-data.png 

To store this kind of data |ivy| provides a simple repository that is
called Business Data. This stored data can then be accessed by multiple process
instances during the lifetime of a long living complex process. The repository
provides access to the data with simple store and load functions similar to well
known other repositories such as the EntityManager from JPA. But in comparison
to JPA and similar technologies this repository can be used without any database
or environment configuration.

::

   CreditRequest creditRequest = ivy.repo.get(CreditRequest.class); // load a CreditRequest from the Business Data Repo
   creditRequest.amount = 30000; // modify a field
   ivy.repo.save(creditRequest); // save the modified CreditRequest back to the Repo.

By annotating a data class with the ``@BusinessCaseData`` annotation, all values
of the annotated data class are automatically associated with the context of the
current Business Case. The data is then shared and accessible from all processes
belonging to the Business Case. Multiple data classes of different types can be
used inside a Business Case.

Business Data Analytics
~~~~~~~~~~~~~~~~~~~~~~~

Running business processes typically generate highly valuable data, which could
influence critical business decisions. Based on the stored data you will
typically want to visualize KPIs on a management dashboard. In our credit
sample, you may want to visualize the aggregated sum of all open credits. The
data in the Business Data repository is stored in form that is easily accessible
and explorable with a tool like `Kibana
<https://www.elastic.co/products/kibana>`__.

.. figure:: /_images/adaptive-case-management/acm-data-analysis.png 


.. _adapative-case-management-big-picture:

Regaining the Big Picture
~~~~~~~~~~~~~~~~~~~~~~~~~

Real world BPM projects have shown that big processes tend to get increasingly
complex and need to be split up into huge process landscapes, which leads to an
intransparent main process flow. Users of the process often do not see how their
work contributes to the bigger business process and therefore great
opportunities for improvements are not seized. There is also a big need for a
unique view of adaptive case operations that can be used by process
contributors. Like an overview of optional tasks that a clerk can start at any
time.

The Case Map addresses the needs for flexible and agile Business Cases by
providing a clear and simple view on the main process and its execution. With
the Case Map you can easily orchestrate the main flow of processes and the
business can identify and track the stages where a running process instance is.

.. figure:: /_images/adaptive-case-management/casemap-lending.png 

A Case Map is divided into stages (in the sample above the stages are:
Identification, Credit rating and Approval). Each stage defines a certain phase
in the life cycle of a business process. A stage consists of processes (e.g.
"Collect personal data"). The default flow (also known as the **happy path**) is
from left to right and from top to bottom. If the last process of a stage has
finished the flow continues on the stage to the right of the current stage.
Stages typically have a name and icon. The idea is to reuse these icons in
Workflow UIs and processes to give the end user a hint in which stage the
current Business Case is.

.. figure:: /_images/adaptive-case-management/acm-casemap-portal.png 

Besides processes a stage of a Case Map can contain Sidesteps (e.g., "External
solvency service" in the Case Map above). Sidesteps can be started manually by
the workflow user during the ongoing Business Case. A typical Sidestep could be
a process which aborts the business process (e.g., abort request). The use of
Sidesteps can reduce the time spent on technical round trips, for modeling rare
and costly edge cases.

.. figure:: /_images/adaptive-case-management/acm-casemap-portal-sidestep.png 

The dependencies between Case Map, Business Cases and Business Data are as
follows: Processes started inside a Case Map create new cases inside the
Business Case, which themselves contain tasks for the users. Data between
processes can be easily shared using Business Data. A Business Case can be
attached to a Case Map, which in turn controls the flow of the processes.

.. figure:: /_images/adaptive-case-management/casemap-businesscase-relation.png
   :alt: Relationship between Business Case, Business Data and Case Map.

   Relationship between Business Case, Business Data and Case Map.

Conclusion
~~~~~~~~~~

To reiterate: signals and triggers can be used to loosely or tightly couple
different processes. The innovative Case Map brings order to chaos of spaghetti
BPM. A domain expert always has a simple graphical view on the Business Case to
which he contributes. The Case Map empowers the domain expert to control the
process execution by starting optional Sidesteps or gracefully skipping large
parts of the pre-modeled standard flow.

The Case Map gives the developer and the user a common language to talk about a
complex process landscape. The Case Map can be read and understood by anyone
that contributes to the process without an introduction. This brings back the
old BPM ideas that stood the test of time.




.. _signal-reference:

Signal Reference
----------------

Signals inform an unknown number of recipients that a specific event has
happened. Signals are sent application-wide without the need for project
dependency between the sender and receiver.

Sending Signals
~~~~~~~~~~~~~~~

A Signal is sent programmatically and consists of a Signal Code and
optional signal data.

.. note::

   Signal codes are defined as strings. Only letters and numbers
   ``[A-Za-z0-9]`` as well as the colon ``:`` as a separator are allowed.

   Valid: ``hr:employee:quit``, ``flight:cancel:no:LX1398``

Send a Signal Programmatically
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Send a signal with a custom signal code using the following IvyScript code:

::

   import ch.ivyteam.ivy.process.model.value.SignalCode;

   // send simple signal
   ivy.wf.signals().send("datarepository:updated");

   // send signal with reference
   ivy.wf.signals().send("order:canceled:"+in.order.id);

   // send signal with signal data
   ivy.wf.signals().send(new SignalCode("user:created"), in.employee.name);

.. tip::

   It is not recommended to use data classes as signal data as not all receiving
   projects might have access to these data classes. Better send an id which
   references an object in a database or send payload data that is encoded as
   string (e.g., JSON).

Send a Signal Manually in the Designer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

While developing a process it is possible to send a Signal manually in
the :guilabel:`Signals` page of the :ref:`designer-workflow-ui`.

Receiving Signals
~~~~~~~~~~~~~~~~~

Signals are received by Signal Boundary Events and Signal Start Events.
Receivers can either register for an explicit signal code or a generic
:ref:`signal-receive-patterns`.

Signal Boundary Event
^^^^^^^^^^^^^^^^^^^^^

A :ref:`process-element-signal-boundary-event` attached to a User Task Element
destroys the task if a matching signal is received and the task is in SUSPENDED
state (see also :ref:`signal-boundary-event` in the Workflow chapter). The
inscribed pattern on the Signal Boundary Event defines the filter for awaited
signal codes:

Listen for a canceled order signal with a specific id defined as
macro:

::

   order:canceled:<%=in.orderNr%>

Listen for signals that have a ``created`` postfix. E.g
(``user:created``, ``order:created``).

::

   *:created

|image5|

.. warning::
   Do not send a signal in a task that is aborted by that signal. Instead, use an additional System task to send the signal. 
   Otherwise, the task that sends the signal will be destroyed leading to an error in the execution of that task.


|image6|


Signal Start Event
^^^^^^^^^^^^^^^^^^

With a :ref:`process-element-signal-start` a new process is started if a
matching signal code is received.

|image7|

.. _signal-receive-patterns:

Signal Patterns
^^^^^^^^^^^^^^^

Receivers can listen to a specific signal by its full qualified name. Besides,
it is also possible to catch multiple signal sources by listening to its common
prefix. Moreover, signal listener pattern can contain wildcards (*) so that the
prefixes do not have to be shared necessarily.

::

   # passenger on-boarding
   ivy.wf.signals().send("airport:passenger:boarding:3424");

.. table:: Signal receivers for signal code Signal 'airport:passenger:boarding:3424'

   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | Listener pattern                                          | Fired?          | Reason                                 |
   +===========================================================+=================+========================================+
   | ``airport:passenger:boarding:3424``                       | true            | Full qualified match                   |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``airport:passenger:boarding``                            | true            | Prefix matches                         |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``airport:passenger``                                     | true            | Prefix matches                         |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``airport``                                               | true            | Prefix matches                         |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   |                                                           | true            | Empty matches all signals by prefix    |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``airport:crew:boarding``                                 | false           | Different prefix part: ``crew``        |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``airport:*:boarding``                                    | true            | Wildcard matches                       |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``*:*:boarding``                                          | true            | Wildcard matches                       |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   | ``*:boarding``                                            | false           | Only one wildcard instead of two       |
   +-----------------------------------------------------------+-----------------+----------------------------------------+
   

Tracing Signals
~~~~~~~~~~~~~~~

Signals can be traced by using the :ref:`designer-workflow-ui`. It makes use of
the Public API for Signals (``ivy.wf.signals()``).

.. tip::

   For debugging the signal data of a Signal event you can set a
   :ref:`simulate-process-models-breakpoints` on a Signal Start or Signal
   Boundary Event and inspect the signal variable in the 'Variables' view.

.. |image0| image:: /_images/adaptive-case-management/invoke-triggerable-start.png
.. |image1| image:: /_images/adaptive-case-management/triggerable-start-request.png
.. |image2| image:: /_images/adaptive-case-management/hr-signaled-processes.png
.. |image3| image:: /_images/adaptive-case-management/attach-to-signaled-case-inscription.png
.. |image4| image:: /_images/adaptive-case-management/credit-amount-change-listener.png
.. |image5| image:: /_images/adaptive-case-management/signal-boundary.png
.. |image6| image:: /_images/adaptive-case-management/quit-task-over-signalboundery.png
.. |image7| image:: /_images/adaptive-case-management/signal-start.png
