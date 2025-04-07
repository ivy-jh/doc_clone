
.. _process-inscription-browsers:

Inscription Browsers
========================

Various process element inscriptions involve dynamic parts. 
With convenient inline browser, you can select contents from your project to be used within the inscription configuration.



Accessibility
~~~~~~~~~~~~~

|search-action| The search button on inscription inputs will open the browsers for selection.

**Apply**: adds the selected attribute to your process element inscription.

**Cancel**: closes the browser and re-opens the process element inscription.

.. |search-action| image:: /_images/ui-icons/list-search.svg
   :width: 2em   


.. _attribute-method-browser:

Attribute Browser
----------------------------

A browser to select valid attributes of the process datas for scriptable process element configurations.

.. figure:: /_images/process-inscription/browser-attribute.png
   :alt: Attribute Browser

   Attribute Browser

In the upper left area, you can choose between the different process
attributes in the current context (such as ``in``, ``out``, ``param``, ...).


.. _function-browser:

Function Browser
----------------

This browser is used to construct and insert IvyScript expressions in inscription masks. 
Those expressions are based on the environment in the context of the current process or on
general-purpose functions.

.. figure:: /_images/process-inscription/browser-function.png
   :alt: Function Browser

   Function Browser

A description of the accessible objects can be found in the section :ref:`ivy
environment variables <ivyscript-reference-environmentvariable>`



.. _data-type-browser:

Data Type Browser
-----------------

The data type browser is used to choose a data types in inscription masks.
By default DataClasses from your project or its dependencies can be selected.

.. figure:: /_images/process-inscription/browser-type.png
   :alt: Type Browser

   Type Browser

**Options**

- `Search over all types`: include types from Java libraries.
- `Use Type as List`: will pick a List of the selected type.


.. _cms-browser:

CMS Browser
-----------------

The CMS browser selects translatable contents from the :ref:`cms`. 

.. figure:: /_images/process-inscription/browser-cms.png
   :alt: CMS Browser

   CMS Browser

**Options**

- `Enable required projects`: lookup CMS contents from dependent projects too.



.. _role-browser:

Role Browser
-----------------

Selects a role of your project.

.. figure:: /_images/process-inscription/browser-role.png
   :alt: Role Browser



.. _large-code-browser:

Fullscreen Code Browser
--------------------------

Renders the scripts in a :ref:`process-element-tab-code` at full size. 

.. figure:: /_images/process-inscription/browser-codeFullscreen.png
   :alt: Fullscreen




