.. _overrides:

Overrides
==========

Applications are often implemented as a general solution for a problem
and consist of multiple (dependent) projects. For many installations or
customer projects it is desirable that certain parts of such a generic
solution may be redefined in the context of a specific installation or
customer.

To permit this, |ivy| knows various concepts of context-sensitive
re-definitions:

-  Regular redefinition (e.g., for Content Objects and/or
   Configurations): Simply define an already existing artifact with the
   same name again in a different project.

-  Redefinition with overrides (e.g., for HTML Dialogs, HTML Dialog components
   and/or Sub Processes): Define a replacement component for an already
   existing component.

By defining overrides on project level, the lookup of a certain
component can be redirected to a replacement component. When a component
is referenced in a process model of that project then the lookup for
this component will yield a different component (i.e., the replacement)
at runtime instead of the originally referenced component.

Example: The Acme Web shop
--------------------------

As an example, imagine a web shop application. It contains the following
(generic) business process:

.. figure:: /_images/overrides/webshop-process.png
   :alt: Web Shop Process

The main process itself (Order) and each of the depicted sub processes
(DoOrder, ProcessOrder, Shipment) are defined in their own projects. All of
those projects together form a (generic) web shop application, depicted
below. The web shop project contains the business process and its
start; the Frontend project contains the DoOrder sub process; the
Backend project contains the ProcessOrder sub process; the Shipment
project contains the Shipping sub process.

.. figure:: /_images/overrides/case-scope-1.png
   :alt: Overriding 1

We now define an additional project, *Acme web shop*. The new project is
dependent on web shop and the intention is to bundle all Acme-specific
overrides and adoptions in this project. The already existing projects
plus this new project form together a more specific and customized *Acme
web shop* application, with the following project dependency tree:

.. figure:: /_images/overrides/case-scope-2.png
   :alt: Overriding 2

Knowing this, we can now specifically override and redefine components
from the original generic *web shop* application by redefining them
inside the *Acme web shop* project.

There are two ways to use the *Acme web shop* project as an overriding
project. You can either define a :ref:`strict_overriding` in
the generic *Web shop* application. 
To start with however, make sure your overriding project
is dependent on the base project and that each override is defined
in your overriding project as described in :ref:`overrides-editor`.


.. _strict_overriding:

Strict Overriding
-----------------

If you want to customize your standard product for a specific
customer then the easiest way to realize overrides is by defining an
overriding project which contains all the customized components.
This means that overridden components are always resolved from
the overriding project, if they exist.

In our webshop example the overriding project would be the *Acme web shop*.
Starting a process from either the *Web shop* or the specialized
*Acme web shop* will always result in the overridden components
being loaded. Not overridden components will still be loaded from
the base *Web shop* project.

By defining the overriding project you can leave complex business processes
in the base project and only define specialized components in the overriding
project.

The lookup of components happens hierarchically. If the engine
cannot locate an overridden component in the overriding project
it will go down the dependency tree until it encounters the
wanted component. So maybe you want to provide a third webshop
which builds upon the *Acme web shop*. In this case the overriding
project would be the most specialized web shop in the dependency tree.


.. _strict_overriding_config:

Configuration
~~~~~~~~~~~~~~

   To strictly set the overriding project you have to configure it in
   the :ref:`app-yaml`.

   .. literalinclude:: includes/sample-projectOverride.yaml
      :language: yaml

   .. note::

      While working on your project with strict overriding you have to define
      the overriding project in the **Designer** as well. This can easily be
      achieved with the :ref:`overrides-editor`. Alternatively you can find
      the :ref:`app-yaml` for the Designer under
      *designerDir/configuration/app-designer.yaml*.

   .. warning::

      Overrides cannot be "stacked" - you can only override a component that is
      not itself an override. |ivy-designer| will warn you about this.


Overrides Tool Reference
------------------------

.. _overrides-editor:

Override editor
~~~~~~~~~~~~~~~

The |ivy| *Overrides Editor* shows the registered and active
overrides for a specific project. The overrides are listed in 4
different sections: Sub Processes, HTML Dialogs, Content Objects and
Configurations.

At the top of the editor, you can define the :ref:`strict_overriding` project.
With this, you may simulate the overriding experience of the application within the Designer.

Html Dialog and Sub Process overrides require - for technical reasons - the registration
of a mapping (this is done automatically by the New Override Wizard)
which maps the original component's identifier to the replacement
identifier. This mapping is displayed in the Override Editor and can be
deleted by selecting an entry and subsequently clicking on the *delete*
icon in the section's tool bar. When clicking on the *wizard* icon in
the tool bar, a new override mapping of that category can easily be
added by entering all necessary information into the opening wizard.

Overrides of Content Objects and Configurations, on the other hand, do
not require a renaming and an extra mapping between the original and the
overriding component. They are simply created by adding a new Content
Object or Configuration entry with the name of a component that already
exists in a required project. At runtime, the new component will be
found first and thus shadow the original value. For this type of
override no special actions are available from the editor; you should
use the respective editors (Content Editor and Configuration Editor) to
create or delete overrides. The editor shows the overrides of that type
for reasons of a centralized overview and for convenience, rather than
to provide an interface to edit them.

.. figure:: /_images/designer-configuration/overrides-editor.png
   :alt: Override Editor

   Override Editor

Accessibility
~~~~~~~~~~~~~

|override-tree-node|

|ivy| Project Tree > double click on the Overrides node.


Features
~~~~~~~~

Sub Process Overrides
   This section shows all Sub Process overrides that are registered for
   the selected project. You can delete an existing override by pressing
   the *delete* icon in the section's tool bar. This will only delete
   the mapping (and thus the execution of the override) but not the
   replacement Sub Process itself. You can add new Sub Process overrides
   by clicking on the *wizard* icon in the tool bar (this can also be
   used to "restore" a previously deleted mapping).

Html Dialog Overrides
   This section shows all HTML Dialog (HD) overrides that are registered for
   the selected project.

   Overrides can be defined for full HDs as well as for HD components.
   Override a full HD - defined in a (sub) process - or a HD component defined
   in a parent project by adding a mapping entry in this section.
   See chapter :ref:`user-dialogs` for more information about HDs.

   You can delete an existing override by pressing the *delete* icon in the
   section's tool bar. This will only delete the mapping (and thus the
   execution of the override) but not the replacement HD itself. You can
   add new HD overrides by clicking on the *wizard* icon in the tool bar
   (this can also be used to "restore" a previously deleted mapping or if you
   want to override a HD with an already existing dialog).

Content Object Overrides
   This section shows all Content Objects that are redefined in the
   selected project, i.e.,the Content Objects for which there is an
   entry with the same URI in a required project. At execution time the
   redefined Content Object will be used.

   You can delete overriding Content Objects directly from the list
   (multi-select a few lines and hit *Delete*) or use the Content Editor
   to add new overriding Content Objects.

.. |override-tree-node| image:: /_images/designer-configuration/overrides-treenode.png




.. _override-new-wizard:

New Override Wizard
~~~~~~~~~~~~~~~~~~~

The *New Override Wizard* lets you create a new override. The wizard
performs two tasks:

1. It will create an independent copy (snapshot) of the original
   component with a new name in the current project.

2. It will create and register a mapping <original,replacement> in the
   list of overrides that are known to the system. The list of those
   mappings can later be inspected and edited with the
   :ref:`overrides-editor`.

3. It will ask you if it should add the configuration for
   :ref:`strict_overriding` to the *designer/app.yaml* if necessary.

.. note::

   Please be aware that any Sub Process that is being overridden must
   have "use own data class" explicitly set in it's inscription. 

   If this is not the case the wizard refuses to create an override for this reason then you
   can set an explicit data class in the values tab of the original
   process's inscription.

.. figure:: /_images/designer-configuration/overrides-wizard.png
   :alt: New Override Wizard

   New Override Wizard


Accessibility
~~~~~~~~~~~~~

File > New > Override

Features
~~~~~~~~

Original Type
   Choose the type of component for which an override replacement should
   be created (Html Dialog or Sub Process).

Original Identifier
   Specify the identifier of the original component that should be
   overridden at runtime. Use the button next to the text field to
   select from the available HTML Dialogs or Sub Processes. Please note that
   only components from required projects can be overridden, there is no
   point in defining an override for a component in the same project
   (see :ref:`overrides`).

Existing component
   If you want to override the original compoenent with an already existing
   one, choose the button next to the Project drop-down box to select one
   from the current project.

Replacement Namespace
   Chose a namespace for the replacement component.

Replacement Name
   Enter the name of the replacement component.

   .. note::

      If you create an override for a Sub Process, then a copy of the
      data class of the original component will be created (snapshot)
      and will be associated with the replacement process. The name of
      the copied data class will be inferred from the replacement
      component's identifier (namespace + name).

Finally...
   Select whether you want the respective component's editor to open on
   the replacement component once the override has been created.

