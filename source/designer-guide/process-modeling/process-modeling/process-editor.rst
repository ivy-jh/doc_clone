.. _process-editor:

Process Editor
--------------

The Process editor is used to design and edit the different process kinds
(mostly *business* and *User Dialog logic* processes). The Process editor
has different parts:

-  the :ref:`process-editor-area`, where the process logic is constructed element
   for element

-  the :ref:`process-editor-tool-bar`, where some tools are located and also all
   elements, which can be added to the process

-  the :ref:`process-editor-viewport-tool-bar`, where some tools for the
   viewport are located

-  the :ref:`process-editor-quick-actions`, where you find quick actions according to the current selection


|image2|

Accessibility
~~~~~~~~~~~~~

Axon Ivy Project Tree > double click on a *process* node inside the
project tree (|image3|)

.. _process-editor-tool-bar:

Tool Bar
~~~~~~~~

The **Tool Bar** collects all tools that can be helpful for working with the
process editor:

Left
^^^^

|select-tool| Select: an element in your process.

|marquee-tool| Marquee: grab multiple elements from your process. 
The Marquee Tool can also be started if you hold *Shift* or you can select multiple elements by hold *Ctrl*.

|undo-tool| Undo: your last changes.

|redo-tool| Redo: your last changes.

.. |select-tool| image:: /_images/ui-icons/selection-tool.svg
   :width: 2em

.. |marquee-tool| image:: /_images/ui-icons/multi-selection.svg
   :width: 2em

.. |undo-tool| image:: /_images/ui-icons/undo.svg
   :width: 2em

.. |redo-tool| image:: /_images/ui-icons/redo.svg
   :width: 2em


Center
^^^^^^

You can create many different elements, by select the wished element and add
it to a position in the diagram. To keep the overview they are divided into
different categories: 

- All Elements
- Events
- Gateways
- Activities
- Artifacts
- :ref:`Extensions <process-element-extension-item>`


Right
^^^^^

|open-dataclass| Opens the :ref:`data-class-editor` of the process.

|inscription-toggle| Opens or closes the :ref:`process-inscription-view` of the process.

|options-toggle| Open view options:

   - Darkmode: Toggle between dark and light theme.
   - Grid: Toggle the grid mode. (You can also set the grid mode in the :ref:`process-editor-preferences`)
   - Custom Icon: Toggle between custom and default icons.

.. |open-dataclass| image:: /_images/ui-icons/database-link.svg
   :width: 2em

.. |options-toggle| image:: /_images/ui-icons/settings.svg
   :width: 2em

.. |inscription-toggle| image:: /_images/ui-icons/layout-sidebar-right-collapse.svg
   :width: 2em


.. _process-editor-viewport-tool-bar:

Viewport Tool Bar
~~~~~~~~~~~~~~~~~

|origin-view-tool| Reset process editor to the origin viewport.

|fit-to-screen-tool| Fit the whole diagram (or your current selection) to the process editor screen.

|center-tool| Center the whole diagram (or your current selection) in the process editor screen.

Zoom level: Displays the current zoom level of the process editor.

.. |origin-view-tool| image:: /_images/ui-icons/window-minimize.svg
   :width: 2em

.. |fit-to-screen-tool| image:: /_images/ui-icons/fit-to-screen.svg
   :width: 2em

.. |center-tool| image:: /_images/ui-icons/center.svg
   :width: 2em

.. _process-editor-area:

Editor Area
~~~~~~~~~~~

Processes are designed, drawn and modified in the process editor area.
Select an element from the palette, then click in the process editor
area to place it. Click and drag elements to move them.

Connectors are drawn between two elements by using the **Connector Tool** in the
:ref:`process-editor-tool-bar` or clicking on the first element and select the
**Connector Tool** over the :ref:`process-editor-quick-actions`. You can also
add more bend waypoints to a connector or move them, by select the connector
and drag the handles. To reconnect a existing connector select the connector and
move the target handle to another element.

On each element you have a :ref:`process-editor-quick-actions`, which provides
useful actions to edit the element. If you select multiple elements, you have
access to the :ref:`process-editor-quick-actions-multi`. And also on
:ref:`connectors <process-editor-quick-actions-connector>` and :ref:`swimlanes
<process-editor-quick-actions-lanes>` you will get a Quick Action Menu.

To scroll in the process editor simply drag the diagram. If you want to Zoom,
use your mouse wheel. To undo/redo or copy/paste you can use the **Edit** menu
of the IDE or use the default shortcuts (`Ctrl + C`, `Ctrl + V`,
etc.).


.. _process-editor-quick-actions:

Quick Action Menu
^^^^^^^^^^^^^^^^^

To open the **Quick Action Menu** simply select an element in the editor. The
available actions can be different based on the element type:

|delete-action| Delete the current selection.

.. _process-editor-quick-actions-start-process:

|start-action| Starts/Runs the selected process.
Only available on the :ref:`Start Element <process-element-start-request>`

|info-action| Information about the current selection (:ref:`problem markers 
<problems-view>`, :ref:`name <process-element-tab-general>`, :ref:`description 
<process-element-tab-general>`, PID, conditions, etc.).

|search-action| Search all usages of this start event. *Only available on some start events*


.. _process-editor-quick-actions-toggle-breakpoint:

|breakpoint-action| Toggle Breakpoint: To suspend the execution. 
:ref:`process-element-breakpoints` can be added to process elements.
 
|jump-in-action| Enters the embedded or referenced process and shows the encapsulated process.
*Only available on elements with an reference to another process*

|unwrap-action|  The elements encapsulated by the embedded subprocess are placed into the current process.
Only available on :ref:`process-element-embedded-sub` or
:ref:`process-element-bpmn-activity`

|edit-label-action| Opens an inline editor for the label of the currently selected element.

|goto-source-action| Jump to the referenced view or java class.
*Only available on elements with a referenced view or java class*   

|icon-action| Changes the icon of the process element. If the icon is already a custom icon
the click will reset it to the default icon. Any image of the project can be
used as decorator icons.  

.. include:: _select-color-quick-action.rst

Add Element:
   Directly insert an element to the process workflow. There are three
   categories of elements:

   - Events: All possible event elements (also for
     :ref:`process-element-error-boundary-event` and
     :ref:`process-element-signal-boundary-event`)
   - Gateways
   - Activities

   .. tip::
     
     Press the key :guilabel:`A` to get a list of all elements. 
     You can also navigate through the list with the :guilabel:`Arrow` keys and 
     add an element with the :guilabel:`Enter` key.

|connect-action| The **Connection Tool** can connect the current element with another.
*Only available if the element has no outgoing connector or supports multiple
outgoing connectors*

.. |start-action| image:: /_images/ui-icons/play.svg
   :width: 2em  
.. |search-action| image:: /_images/ui-icons/search.svg
   :width: 2em
.. |breakpoint-action| image:: /_images/ui-icons/bug.svg
   :width: 2em
.. |jump-in-action| image:: /_images/ui-icons/sub-start.svg
   :width: 2em
.. |unwrap-action| image:: /_images/ui-icons/unwrap.svg
   :width: 2em  
.. |goto-source-action| image:: /_images/ui-icons/go-to-source.svg
   :width: 2em  
.. |icon-action| image:: /_images/ui-icons/custom-image.svg
   :width: 2em  
.. |connect-action| image:: /_images/ui-icons/connector.svg
   :width: 2em  

.. _process-editor-quick-actions-multi:

Multi-Selection Quick Action Menu
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

If you select multiple elements, e.g with the **Marquee Tool** of the
:ref:`process-editor-tool-bar`, you get access to a **Multi-Selection Quick
Action Menu**. The following actions are available:

|delete-action| Delete the current selection.

|wrap-action| Wrap the current selection into an embedded process.

|auto-align-action| Aligns the selected elements *horizontally* and *vertically*.

.. include:: _select-color-quick-action.rst

.. |wrap-action| image:: /_images/ui-icons/wrap-to-subprocess.svg
   :width: 2em  

.. |auto-align-action| image:: /_images/ui-icons/auto-align.svg
   :width: 2em  



.. _process-editor-quick-actions-connector:

Connector Quick Action Menu
^^^^^^^^^^^^^^^^^^^^^^^^^^^

To open the **Connector Quick Action Menu** select a connector. The following
actions are available:

|delete-action| Delete the current selection.

|info-action| Information about the current selection (:ref:`problem markers
<problems-view>`, :ref:`name <process-element-tab-general>`, :ref:`description
<process-element-tab-general>`, PID, conditions, etc.).
   
|straigten-action| Straighten: Change layout of the arrow path to a straight line.

|bend-action| Bend: Change layout of the arrow path to horizontal and vertical lines with 90° angles.

|edit-label-action| Opens an inline editor for the label of the currently selected element.

.. include:: _select-color-quick-action.rst

|reconnect-action| Trigger a reconnection of the selected connector, by selecting a new target element.

   .. tip::

     You can also trigger a reconnection by pressing the target handle on the selected connector

.. |straigten-action| image:: /_images/ui-icons/straighten.svg
   :width: 2em  
.. |bend-action| image:: /_images/ui-icons/bend.svg
   :width: 2em  
.. |reconnect-action| image:: /_images/ui-icons/reconnect.svg
   :width: 2em  



.. _process-editor-quick-actions-lanes:

Swimlane Quick Action Menu
^^^^^^^^^^^^^^^^^^^^^^^^^^

To open the **Swimlane Quick Action Menu** select a pool or a lane. The following
actions are available:

|delete-action| Delete the current selection.

|edit-label-action| Opens an inline editor for the label of the currently selected element.

.. include:: _select-color-quick-action.rst

|lane-action| Adds a lane to a pool.

.. |lane-action| image:: /_images/ui-icons/lane-swimlanes.svg
   :width: 2em   


.. |delete-action| image:: /_images/ui-icons/trash.svg
   :width: 2em   
.. |edit-label-action| image:: /_images/ui-icons/label.svg
   :width: 2em   
.. |info-action| image:: /_images/ui-icons/info-circle.svg
   :width: 2em   
.. |color-action| image:: /_images/ui-icons/color-drop.svg
   :width: 2em   


Shortcut Keys
^^^^^^^^^^^^^

Some of the *tools* and *quick actions* are available with shortcut keys. To use
them, select the element, then press the associated key.


Jump out
^^^^^^^^

|jump-out-action| Visible in the top left of the :ref:`process-editor-area` to jump out of an
*embedded subprocess* to the process that contains the *Embedded Sub* element.

*Only active if you're in an embedded subprocess*

.. |jump-out-action| image:: /_images/ui-icons/jump-out.svg
   :width: 2em   


.. |image2| image:: /_images/process-editor/process-editor.png
.. |image3| image:: /_images/process-modeling/process-node.png
