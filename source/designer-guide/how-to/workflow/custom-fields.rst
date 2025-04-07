.. _custom-fields:

Custom Fields
=============

Use custom fields to add additional business relevant information dynamically as
key/value pairs on :ref:`Starts<process-element-tab-start-custom-fields>`,
:ref:`Cases<process-element-tab-case-custom-fields>` and :ref:`Tasks
<process-element-tab-task-custom-fields>`. 

Examples of custom fields are:

* branchLocation - The location of the branch that is responsible for a task
* customerId - The id of the customer a case is working on 
* orderAmount - The amount of money of the order associated with a case 

The :ref:`developer workflow UI <dev-workflow-ui>` and the :ref:`Portal
application <portal-guide>` will display custom fields on their task and case
detail pages. In the :ref:`Portal application <portal-guide>`, custom fields can
also be added as additional columns in :ref:`task
<dev-workflow-ui-task-details>` and :ref:`case <dev-workflow-ui-case-details>`
lists, as well as for filtering task- and case lists in dashboards. You can also use custom
fields to search for task and cases.

Meta Information
----------------
 
You can use custom fields directly on the process elements without any
additional configuration. However, we suggest that you provide additional
information (meta information) for custom fields that are used often or are
visible to end-users in the :ref:`Portal application <portal-guide>`. Meta
information for :ref:`custom fields <custom-fields-config>` can be provided in
the file :file:`<project>/config/custom-fields.yaml`. Additionally, you can
provide some attributes of the meta information in :ref:`multiple languages
<custom-fields-locale>` using the :ref:`CMS <cms>`.

Custom Fields API
-----------------

You can access custom fields using the following API:

* :public-api:`ITask.customFields() </ch/ivyteam/ivy/workflow/ITask.html#customFields()>`
* :public-api:`ICase.customFields() </ch/ivyteam/ivy/workflow/ICase.html#customFields()>`
* :public-api:`IWebStartable.customFields() </ch/ivyteam/ivy/workflow/start/IWebStartable.html#customFields()>`

.. code:: java
  
  String branchOffice = ivy.task.customFields().stringField("branchOffice").getOrDefault("Zug")

To search for tasks and cases by custom fields, use the following API:

* :public-api:`TaskQuery.IFilterableColumns.customField() </ch/ivyteam/ivy/workflow/query/TaskQuery.IFilterableColumns.html#customField()>`
* :public-api:`CaseQuery.IFilterableColumns.customField() </ch/ivyteam/ivy/workflow/query/CaseQuery.IFilterableColumns.html#customField()>`

.. code:: java
  
  TaskQuery taskQuery = TaskQuery.create();
  List<ITask> tasks = taskQuery.where()
    .customField().stringField("branchOffice").isEqual("Luzern")
    .orderBy().name().ascending();
    .executor().results();

You can access the meta information of custom fields with the following API:

* :public-api:`ICustomFieldMeta </ch/ivyteam/ivy/workflow/custom/field/ICustomFieldMeta.html>`
* :public-api:`ICustomField.meta() </ch/ivyteam/ivy/workflow/custom/field/ICustomField.html#meta()>`
* :public-api:`IStartCustomField.meta(String) </ch/ivyteam/ivy/workflow/start/IStartCustomFields.html#meta(java.lang.String)>`

.. code:: java

  String label = ivy.task.customFields().stringField("branchOffice").meta().label();
  
To access additional attributes, use this API:   

.. code:: java

  String icon = ivy.task.customFields().stringField("branchOffice").meta().attribute("Icon");

To access localized values, use this API:

.. code:: java

  ICustomStringField branchOffice = ivy.task.customFields().stringField("branchOffice");
  String branchOfficeValueLabel = branchOffice.meta().values().label(branchOffice.getOrNull()); 
