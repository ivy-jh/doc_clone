Workflow
--------

By default, HTML Dialogs are created with a proceed button that resumes the
workflow. In addition, a cancel link is created. 

Cancel HTML Dialog
^^^^^^^^^^^^^^^^^^

The default cancel link resets the current task and redirects to the
:ref:`application home <standard-processes-default-pages>` or to the :ref:`task
list <standard-processes-default-pages>` page if the :ref:`task is persistent
<workflow-states>`. You can also define the target redirect page. Have a look at
the :public-api:`WorkflowBean </ch/ivyteam/ivy/jsf/bean/wf/WorkflowBean.html>`
for more information.
