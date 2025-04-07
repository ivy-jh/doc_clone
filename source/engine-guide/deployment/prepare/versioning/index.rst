.. _deployment-versioning:

Versioning
^^^^^^^^^^

We recommend to operate a minimal set of project versions on an Axon Ivy Engine.
With each new process model version introduced, you'll add a version that must
be maintained. Therefore, bugs that must be fixed, will need to be fixed in each
of the operated versions, which massively increases your maintenance efforts.
Whenever possible, overwrite the old projects instead of introducing new
versions. However, new versions must be introduced if incompatible changes are
made:

.. rubric:: Persistent Data

* Deleting, renaming or chaning the type of fields in Ivy Data Classes which are persistent
* Changing types of fields that are persistent in business data


.. rubric:: Processes

* Adding new ins/out of Task Switch and Task Switch Gateway.
* Embedded subs if they are on the call stack of a running task.
* Changing the name or params of call subs if they are used in dependent projects.
