Roles and Users
===============

**Role** is a widely used term in the computer industry and means a group of
users in a system who share a common property. This allows an
administrator to define configurations for these groups (roles) of users
instead of doing so for each user individually.
|ivy| incorporates a sophisticated role and user model to support:

-  **Authentication** - Who may log in to |ivy| - is the user known?
-  **Authorization** - Who is allowed to do what
-  **Task assignment** - Who may perform a task in a workflow
-  **User-dependent UI elements** - Who can see and operate on UI elements

In the following two sections, you will learn how to create, edit and
remove roles and users, and how to link users to roles and vice versa.


Role Concept
------------

The hierarchy of the roles is built upon the principle of specialization. Each
child role specializes on its ancestor role(s), i.e., a role **Team A** always
implicitly contains its ancestor role(s). The role **Everybody** is the root for
all other roles; all other roles are more specialized than Everybody. In the
figure below, a member user of role **Team A** also has the roles
**Development** and **Everybody**.

A typical |ivy| Role tree might look like this:

   ::

      + Everybody
        + Support Group
          + First Level
          + Second Level
        + Development
          + Team A
          + Team B

        + Application Permissions
          + Process M
            - First Level (Member Role linked to role 'First Level')
            - Team B (Member Role)
          + Process N
            - Support Group (Member Role linked to role 'Support Group')


Member Role
~~~~~~~~~~~

You can add a **Member Role** as a child of an existing **Role** that links to
another existing **Role**. While resolving the role tree, to collect the
specializations of each role, the **Member Role** is handled like a normal child
**Role**. This simplifies the configuration and administration of roles.

.. tip::

   The concept of **Member Roles** allows you to create a sub-tree of roles with
   **Organizational Roles** and another sub-tree with **Permission Roles**. The
   sub-tree of **Organizational Roles** represents typically the structure of
   the company. The sub-tree of **Permission Roles** represents the usage or
   execution permission of a specific part or feature of an application. With a
   **Member Role**, it is possible to assign permissions to an **Organizational
   Role** by adding it as a member role of one or more **Permission Roles**.

   The above configuration illustrates that users of group **First Level**
   and **Team B** have the permission for **Process M** and users of both
   support sub-groups and the **Support Group** itself have the permission for
   **Process N**.


.. _role-editor:

Role Editor
-----------

The role editor allows to create, edit, or remove roles as well as to structure
roles hierarchically. Double click on the :guilabel:`Roles` node in the
:ref:`ivy-project-view`.

.. figure:: /_images/designer-configuration/role-editor.png
   :alt: Role Editor
   :align: center
   
   Role Editor

The left side of the Role editor consists of a tree showing all the roles in a
hierarchical order. A click on one of the roles will show the properties of the
selected role on the right side of the editor. Manipulate the role hierarchy by
dragging a role and dropping it at its new location in the hierarchy.

- :guilabel:`New`
  A new role is created as a child of the selected role.

- :guilabel:`Add`
  A role is added as a linked member role to the selected role.

- :guilabel:`Remove`
  The selected role and all its child roles are removed.
  The user is obliged to confirm the removal. Note that the role **Everybody** may not
  be deleted.

- :guilabel:`Import XML`
  A ``roles.xml`` file from another project can be imported for
  convenience reasons.

- :guilabel:`Export XML`
  All roles are exported in an XML file named
  ``roles.xml`` to easily re-use the role hierarchy.

- :guilabel:`Sort`
  The selected roles are sorted alphabetically. If desired, this is
  performed recursively on the children.

.. warning::

   Role names have to be unique within their security context. |ivy| merges roles
   you define in a project with all other roles in the same security context.
   The deployment will fail if a Role with the same name exists in different
   hierarchies. This does not apply for Member Roles.

.. _test-user-editor:

Test User Editor
----------------

Process designers can create, edit and remove test users in the user editor.
Users need a password to authenticate themselves, and they need to be assigned to
at least one role. Double click on the :guilabel:`Test Users` node in 
:ref:`ivy-project-view` to start the Test User Editor.

.. note::

   Test users are only used in the process **simulation** within the
   |ivy-designer|. They are **not** uploaded to the engine during
   deployment. Users for processes deployed on the |ivy-engine| need
   to be created and configured on the engine.
   
.. figure:: /_images/designer-configuration/test-user-editor.png
   :alt: Test User Editor
   :align: center
   
   Test User Editor

On the left hand side of the editor, you see all users with their user names (i.e.
login names) and their full names. For the selected user on the left side, the
specific properties are displayed on the right hand side. You can assign a user to
several roles. He is implicitly assigned to the ancestor roles of the roles you
explicitly assigned him to (see :ref:`role-editor`). You can add additional
properties to each user in terms of string key-value pairs and re-use them within
process steps in :ref:`ivyscript`.

- :guilabel:`New`
  Creates a new user with the specified name.

- :guilabel:`Remove`
  Removes a user from the list.
  The process designer does confirm the removal.

- :guilabel:`Sort`
  Sorts the user list in alphabetical order.

- :guilabel:`Import` 
  Test users from a ``users.xml`` file from another project
  can be imported for convenience reasons.
  
- :guilabel:`Export XML` 
  All users and their corresponding properties are exported into a XML file 
  named ``users.xml`` for easy re-use of test users in another project.

.. tip::

   You do not see the user called **Developer**, because it is a built-in
   user. It belongs to all groups and owns all permissions. The user is
   meant to be used for testing, so it only exists in |ivy-designer|. The
   password of this user is **Developer** (in case you would like to log
   in using IvyScript).
