Process Kinds
-------------

There are different kinds of processes. Their use and capabilities are
explained in the sections below.

.. _process-kind-business:

Business Process
~~~~~~~~~~~~~~~~

Business processes are the *regular* kind of processes that are used to
implement business cases. Business processes contain starts that can be
selected by any user from his/her workflow list or from the list of star
table processes.

.. _process-kind-embedded-subprocess:

Embedded Subprocess
~~~~~~~~~~~~~~~~~~~

An embedded subprocess is essentially a syntactical collapse of elements
into a single element to hide details from process design. They are
available in all other process kinds. The hierarchy of embedded
subprocesses is potentially indefinite, i.e., you can create further
embedded subs inside an already existing subprocess.

Since *embedded subprocesses* are simply a structural means for process
diagram simplification, no mapping of data is required when entering or
leaving this kind of subprocess (i.e., inside an embedded subprocess the
same data is available as inside the caller process).

.. warning::

   Wrapping process elements into an embedded subprocess does not
   influence the functionality of most process elements. But the
   wrapping influences the way process elements are addressed by
   Axon Ivy. This may cause incompatibilities with older versions of the
   process and will hinder you to deploy such a process over an already
   deployed older version of the process. The process elements that may
   cause such incompatibilities are:

   -  :ref:`process-element-task-switch-gateway`
   -  :ref:`process-element-task-switch-event`
   -  :ref:`process-element-wait-program-intermediate-event`

.. _process-kind-callable:

Independent Subprocess (Callable)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

An independent subprocess (callable) is a process, that can be called
from any other process with the *call subprocess element*. Independent
subprocesses can be used to factor out frequently used functionality
which can then be reused by any other process.

Because *callables* are *independent* implementations of processes (or
parts of process logic) they have an own Data Class which might not
match the caller's data. Therefore parameters need to be mapped in both
directions when entering and leaving an independent subprocess.

To create an independent subprocess, select the *callable process*
option from the :ref:`process-new-wizard`. The
created process will contain special start and end elements that must
encompass the process implementation.

.. _process-kind-webservice:

Web Service Process
~~~~~~~~~~~~~~~~~~~

Web Service processes are a special case of *independent subprocesses*.
A Web Service process can be started (i.e., called) from any other
application (or from another process) by using the *Web Service call
element* or any other SOAP web service compatible client..

A web service process will provide a web service with one or more
operations, which are defined by the *Web Service Process Start*
elements within the process. Each of these start elements have their own
input and output parameters that will be mapped to and from the process
data.

Due to the nature of web services, which are intended to be called by
other applications and not by a user directly, no user-interaction (HTML
or User Dialogs) is allowed within such a process. If the process does
contain user-interaction an exception will be thrown.

To create a web service process, select the *Web Service Process* option
from the :ref:`process-new-wizard`. The created
process will contain special start and end elements that must encompass
the process implementation.

User Dialog Logic
~~~~~~~~~~~~~~~~~

User Dialog logic processes are the implementation of the behavior of
User Dialogs, the :ref:`controller <user-dialogs>` in the MVC
pattern. A whole new set of elements is available for this kind of
processes (from the *User Dialog drawer* on the process editor palette),
while other elements (such as *task switch* or *HTML page*) are not
available for conceptual reasons.

A User Dialog logic process is invoked with an *User Dialog* element
inside a *business process*. Its execution starts with an *init start*
element and ends with a *dialog exit* element. The two elements do not
need to have a direct connection (in fact they never have). Once a User
Dialog process is running, it is driven by *user interface events* which
will trigger individual sub processes.

.. note::

   Calling a *process based User Dialog* (and thus executing its logic)
   can (or rather should) be seen as equivalent to calling of a
   *callable process* with the sole difference that the User Dialog
   offers a user interface that allows a user to interact with the
   process logic directly.

   However, from an abstract point of view, a User Dialog is nothing
   else than a function call. It is invoked with a list of (optional)
   arguments and returns a list of result values. This is exactly the
   same behavior as a callable process offers.
