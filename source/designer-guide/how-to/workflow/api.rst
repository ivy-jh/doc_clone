
API
---

There are several APIs to manipulate and query workflow tasks and cases.


Task and Case queries
~~~~~~~~~~~~~~~~~~~~~

The fluent workflow query API supports queries against all existing tasks
and cases. You can write the queries in a SQL-like manner.

.. literalinclude:: code-snippets/task-query/example.java
   :language: java

To retrieve all tasks that the current user can work on using the following
code:


.. literalinclude:: code-snippets/task-query/current_user.java
   :language: java

To execute a query, you need an instance of an IQueryExecutor. Retrieve it
trough the :ref:`ivy environment variable
<ivyscript-reference-environmentvariable>`.

Queries are executed against a single security context by default.


.. warning::

   You can execute queries over all security contexts on the engine and their
   applications in the global workflow context using the Query Executor.
   However, multiple security contexts cannot share a user. Therefore, the
   results of global queries are invalid and meaningless.


.. literalinclude:: code-snippets/task-query/IQueryExecutor.java
   :language: java


Task and Case manipulation
~~~~~~~~~~~~~~~~~~~~~~~~~~

The API to manipulate tasks and cases is available trough the :ref:`ivy
environment variable <ivyscript-reference-environmentvariable>`.

-  ``ivy.case`` (ICase): represents the currently executing process

-  ``ivy.task`` (ITask): represents the user's current work unit in the
   currently executing process.

-  ``ivy.wf`` (IWorkflowContext): addresses all workflow tasks and cases of all
   users for the current security context.

-  ``ivy.session`` (IWorkflowSession): gives access to all workflow tasks and
   cases of the current user.


.. _workflow-api:

REST API
~~~~~~~~

There is an :api-browser-url:`REST workflow API <workflow>` available that
allows third-party services to interact with workflow Tasks, Cases, and the like.

The workflow API is enabled by default. Disable it by setting
the configuration to ``REST.Servlet.API: false``.

.. literalinclude:: includes/disable-rest-api.yaml
  :language: yaml
  :linenos:

You can browse this API by using the :ref:`integration-rest-api-browser`.

If any REST workflow API is missing for your specific use case, keep in mind
that you can provide additional APIs very easily by creating REST API service
classes in your project. See :ref:`integration-rest-provider`
