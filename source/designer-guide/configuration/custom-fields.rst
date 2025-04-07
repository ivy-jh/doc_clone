.. _custom-fields-config:

Custom Fields
=============

In the file :file:`<project>/config/custom-fields.yaml`, you can provide additional information (meta information) for :ref:`custom fields <custom-fields>`. 

The information you provide here is used and displayed on the content assistant in
the :guilabel:`Name` column of the custom fields table in the :ref:`developer workflow UI <dev-workflow-ui>`, 
in the :ref:`Portal application <portal-guide>`. It is available to your applications via the Public API.

Editor
------

The |ivy-designer| offers a **Yaml-Editor** to edit the
:file:`<project>/config/custom-fields.yaml` file, where you maintain additional 
information about your custom fields.

.. literalinclude:: includes/custom-fields.yaml
   :language: yaml
   :linenos: 

- :guilabel:`Label`
  The label that is displayed on user interfaces instead of the custom field name.

- :guilabel:`Description`
  The description that is displayed on user interfaces for the custom field.

- :guilabel:`Type`
  The data type of the custom field. Can be either ``STRING``, ``TEXT``, ``NUMBER`` or ``TIMESTAMP``.

- :guilabel:`Category`
  The category of the custom field. You can use this to categorize your custom fields. 

- :guilabel:`Hidden`
  If hidden, the custom field will not be displayed to end users. Use this to hide 
  technical custom fields from end users. Can be either ``true`` or ``false``.

You can add as many other attributes as you like. E.g., :guilabel:`Icon`.

.. warning::
  The number of `indentation spaces <https://yaml.org/spec/1.2.2/#61-indentation-spaces>`__ needs to be the same in the whole yaml file.


.. _custom-fields-locale:

Localize Label, Description, Category and Values
------------------------------------------------

For processes that support multiple languages, the Label, Description, Category and Values can be provided in multiple languages by using the :ref:`CMS<cms>`.

You need to add the following to the :ref:`CMS<cms>`:

- folder ``/CustomFields/`` in the CMS root folder. This folder is *required*.
- the object kind of the entry - ``Cases``, ``Tasks``, or ``Starts`` are supported. This folder is *required*.
- content objects with paths ``/CustomFields/{kind}/{name}/Label``, 
  ``/CustomFields/{kind}/{name}/Description`` or ``/CustomFields/Categories/{category}``, 
  e.g., ``/CustomFields/Tasks/branchOffice/Label``, ``/CustomFields/Categories/hrm``

You can localize values of ``STRING`` and ``NUMBER`` custom fields. 
This allows you to store a technical code either as ``NUMBER`` or ``STRING`` in a custom field and provide labels for them in the CMS. 
Use the following path to localize your custom field values: ``/CustomFields/{kind}/{name}/Values/{value}``. 

Examples:

- With a ``STRING`` custom field 
  ``CustomFields/Tasks/branchOffice/Values/Zug``, ``CustomFields/Tasks/branchOffice/Values/Munich``, and ``CustomFields/Tasks/branchOffice/Values/Vienna``. 
  Now you can localize the value ``CustomFieldsTasks/branchOffice/Values/Vienna`` by setting it for English to ``Vienna`` and for German to ``Wien``. 
- With a ``NUMBER`` custom field 
  ``CustomFields/Tasks/productType/Values/1``, ``CustomFields/Tasks/productType/Values/2``, and ``CustomFields/Tasks/productType/Values/3``. 
  Now you can give the product types meaningful names like ``Food``, ``Electronic``, and ``Health``. In different languages if you like.
