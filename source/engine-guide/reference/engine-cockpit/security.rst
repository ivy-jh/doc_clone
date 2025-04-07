Security
--------


.. _engine-cockpit-security-system:

Security System
^^^^^^^^^^^^^^^

The security system page provides an overview of every running application
and the security system it is using. In addition, you can trigger the 
synchronization of users and role assignments from the associated 
Identity Provider directly in this UI.

After the synchronization is finished, you will see what it has done in the log.

.. Note::
    Only external security systems can be synchronized.

To define or change a security system, you can either edit it directly in your 
configuration files (see :ref:`configuration-security-system`) or you can 
do it in the engine cockpit: click on the name of the security system to 
open the :ref:`engine-cockpit-security-system-detail` view, 
click :guilabel:`Add` to add a new one.

.. figure:: /_images/engine-cockpit/engine-cockpit-security-system.png


.. _engine-cockpit-security-system-detail:

Security System Detail
""""""""""""""""""""""

In the security system detail view, you can edit a security system.

The settings are read from the :ref:`ivy-yaml` file. 
Every change you make and save is immediately written to the :ref:`ivy-yaml` file. 

The placeholders in the empty fields are the system default values. If your 
settings are the same as the default values, you don't need to define them.

You can configure the default language, the formatting language (date, 
time, number, and currency formatting definitions), and the 
:ref:`workflow languages<workflow-languages>` for the security system. 

.. note::
    If you had something configured and you delete this entry, the entry will be
    removed from the :ref:`ivy-yaml` file. 
    If you remove a language, be aware that the existing entries for that 
    language in the system database are deleted, as well.

.. figure:: /_images/engine-cockpit/engine-cockpit-security-system-detail.png

Generate Security Report
''''''''''''''''''''''''

If you want a complete overview of your security system (e.g., for a security audit),
you can download an Excel sheet with all the necessary information. To download the
Excel, click on the :guilabel:`Download Security Report` button in the Security Systems tab. A dialog 
box will appear, click the :guilabel:`Generate` button, and the Excel file will be prepared. 
The Excel file contains detailed information on users, roles, user roles, role members, 
user permissions, and role permissions. It may take a few minutes to generate. 
When the Excel file is ready you can click :guilabel:`Download`.

Identity Provider
'''''''''''''''''

Depending on the chosen Identity Provider, additional settings are available with the 
:guilabel:`Edit` button.

.. figure:: /_images/engine-cockpit/engine-cockpit-security-system-ldap.png

For all configuration options of an Identity Provider, refer to the chapter
:ref:`identity-provider`.


Users
^^^^^

On this page, you see all users per security system. You can switch the security 
system by clicking on the tabs at the top of the view. 

The user table displays basic information about the users, whether they are
absent and if they currently have an open session.

To add a user, click on the :guilabel:`New` button and fill in the dialog. A user name is
required and needs to be unique within the security system.

.. Note:: 
  You can add local users to internal and external security systems. This
  means that even for external security systems bound to an Identity Provider, you can 
  add and manage local users. Since these users are not managed by the associated 
  Identity Provider, we call them *unmanaged users*.

A click on a user will display its :ref:`engine-cockpit-user-detail` view.

.. figure:: /_images/engine-cockpit/engine-cockpit-users.png


.. _engine-cockpit-user-detail:

User Detail
"""""""""""

In the **User Detail** view, you see the settings of a user. If you added the user 
manually in the |ivy-engine|, independent of the class of the security system, you
can also change the settings.

The :guilabel:`Information` panel displays the attributes of the user. 
For internal security systems, you can change all of them.
For external security systems, you can change all but the unique ID provided by the 
Identity Provider which we use to detect name changes.

It is also possible to enable, disable or delete the user. 

After disabling a user

- he will not be able to log in
- all of his active sessions will be closed
- he won't be counted as a named user for the license
- all tasks assigned to him will be kept assigned to him. 
  These tasks can be queried via the unavailable activator filter 
  using the :public-api:`TaskQuery </ch/ivyteam/ivy/workflow/query/TaskQuery.IFilterableColumns.html#activatorAvailable()>` 
  or the Portal task list. They can then be reassigned 
  to available users by a workflow administrator.
- the history of tasks will not be changed
- his role assignments will not be changed
- he is not displayed in the Users page. Use the special filter on the Users page to see all disabled users.

Deleting a user will also remove him from the users table in the database.

.. Note::
  |ivy-engine| never deletes users automatically. If a synchronized user is deleted 
  in the Identity Provider bound to the security system, the |ivy-engine| will only 
  deactivate the user. If you want to delete deactivated users, you have to do this 
  either manually in the cockpit or supply your own workflow to do so.

The :guilabel:`Roles` panel displays a tree with all roles the selected user is
a member of.

- If the role has a black tick, the user is a direct member of this role.
- If the role has a grey tick, the user inherits the membership from a child or member role.

You can configure additional user properties manually (using the buttons
:guilabel:`Add`, :guilabel:`Edit` and :guilabel:`Delete`) or map them from an 
Identity Provider - see :ref:`engine-cockpit-security-system`. 
Attributes mapped from the Identity Provider like phone number, and department are 
displayed in the :ref:`Additional LDAP Attributes<engine-cockpit-security-system-detail>`.

The :guilabel:`Notification Channels` panel displays the :ref:`notification subscription<notification-subscription>` of the user. 
E.g., on which notification channels the user currently receives which notification events. 
The subscription can be enabled/disabled per notification channel and event. 

The :guilabel:`Substitutes` panel displays all the substitutes the user has
defined. This includes information about whether the substitute is used
permanently or only during absences, if it is a substitute for personal tasks or
tasks of a specific role and the corresponding role if applicable.

The :guilabel:`Absences` panel displays all the registered absences of the user
including a flag, whether they are currently absent or not.

In the :guilabel:`Permissions` panel, you can see what permissions a user has and change
them. A tick is shown if the user has a permission or permissions within a group. 

- If the tick is black, the user has this permission or all the permissions 
  underneath this permission group. 
- If the tick is gray, the user has only some of the permissions of a group.

The user can have permissions granted or denied directly, or through a role. 

Directly granted or denied permissions override permissions inherited from a role.

.. figure:: /_images/engine-cockpit/engine-cockpit-user-detail.png


Roles
^^^^^

The **Roles** page displays a tree of all roles per security system. You can switch the security system
by clicking on the tabs at the top of the view. If a role has child roles, the tree shows a ``>``
icon, which can be expanded by clicking on it.

A click on a role displays its :ref:`engine-cockpit-role-detail` view.

.. figure:: /_images/engine-cockpit/engine-cockpit-roles.png


.. _engine-cockpit-role-detail:

Role Detail
"""""""""""

The **Role Detail** view lets you see role information and change role settings.

The :guilabel:`Role information` panel allows you to edit display name and description
of the role, or link the role to an external security name (a group or a user). Doing so
makes the role a *managed role*.

The :guilabel:`Users` panel allows you to add users to or remove them from the role.

.. Note::
  For a managed role, you cannot change assignments of managed users.
  However, you can assign and remove unmanaged users which you have created on the
  |ivy-engine| in this security system.

Within the :guilabel:`Properties` panel you can edit properties of the role.

The :guilabel:`Role members` panel displays all child roles. You can add or remove
child roles here.

The :guilabel:`Permissions` panel allows you to see and change the permissions
of the role. A tick is shown if the role has a given permission or permissions within a
group. 

- A black tick indicates that the role has this permission or all the permissions in 
  this permission group. 
- A grey tick indicates that the role has only some of the permissions of this permission 
  group.

.. figure:: /_images/engine-cockpit/engine-cockpit-role-detail.png
