.. _ivyscript-editor:

IvyScript Editor
================

Modes
-----

There are two kind of IvyScript editors which are used in different
places.


IvyScript Editor
~~~~~~~~~~~~~~~~

The normal editors expect you to enter either a script with multiple
statements (e.g., a script, that contains semicolons) which performs a
certain task, or just an expression that evaluates to a certain value.


.. _macro-editor:

Macro Editor
~~~~~~~~~~~~

The macro editor allows you to mix IvyScript with normal text. For
example you could name a task dynamically by including the case number
in the taskname. To use IvyScript in this Editor you must use these tags
``<%=%>``.

.. figure:: /_images/process-inscription/code-macro.png


Features
--------

Content Assist
~~~~~~~~~~~~~~

Content Assist is invoked by pressing :guilabel:`CTRL` + :guilabel:`SPACE`
at any point of editing a script. 
Content assist will open a popup, displaying proposals
that are available in the current context, from which you may then
select a suitable option. The selected proposal is inserted into the
editor. You can get proposals for functions, types, packages, variables
and methods and after the keyword ``new`` you also get a list of
constructor proposals.

.. figure:: /_images/process-inscription/code-completor.png
   :alt: Completion proposals


Parameter Hopping
~~~~~~~~~~~~~~~~~

Another special feature is parameter hopping. When you insert a
constructor or a method that has parameters, the first parameter is
selected. When you now press the :guilabel:`Tab` key, then the next parameter gets
selected. This way you may edit one parameter after another and simply
jump to the next one when you're finished. After the last parameter was
selected, the first is selected again. When you have finished, you can
press :guilabel:`Enter` and the cursor jumps to the end of the inserted method or
constructor.

.. figure:: /_images/process-inscription/code-param-hopping.png

   Parameter hopping: After insertion of proposal first parameter is
   selected


Shortcuts
~~~~~~~~~

.. table:: Available Shortcuts inside the IvyScript (and Macro) Editor

   +-----------------------------------+-----------------------------------+
   | Shortcut                          | Action                            |
   +===================================+===================================+
   | CTRL+SPACE                        | Opens content assistant           |
   +-----------------------------------+-----------------------------------+
   | F2                                | When pressing F2 in an editor, a  |
   |                                   | bigger editor is opened in an own |
   |                                   | Dialog.                           |
   +-----------------------------------+-----------------------------------+
   | ESC                               | Inside an editor that was opened  |
   |                                   | with F2, this closes the dialog   |
   |                                   | and stores the entered text in    |
   |                                   | the editor from where the F2      |
   |                                   | editor was opened.                |
   +-----------------------------------+-----------------------------------+
   | CTRL+Z                            | Undo                              |
   +-----------------------------------+-----------------------------------+
   | CTRL+Y                            | Redo                              |
   +-----------------------------------+-----------------------------------+


