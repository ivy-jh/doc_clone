Microsoft Teams Notifications
-----------------------------

This channel provides notifications via Microsoft Teams. 
If this channel is active in a security system with Microsoft Entra ID.
the messages are sent using the user's External ID, which is linked via :ref:`Microsoft Entra ID <microsoft-entra-id>`.
If the External ID is not set (e.g. for local users) or if the Microsoft Entra ID is not configured,
the user's email address is used. If you enable this channel, you also need to:

- :ref:`Create a technical user in the Microsoft Entra ID which serves as the sender of notifications<microsoft-teams-notifications-technical-user>`.
- :ref:`Create an application in the Microsoft Entra ID where the technical user can log in and send messages through<microsoft-teams-notifications-application>`.
- :ref:`Users who shall be notified need to be synced with Microsoft Entra ID <microsoft-entra-id>`.

**Template**

.. literalinclude:: ../../../../target/resources/includes/notification/teams/microsoft-teams-channel-template.yaml
  :language: yaml
  :linenos:

**Reference**

.. literalinclude:: ../../../../target/resources/includes/notification/teams/microsoft-teams-channel-reference.yaml
  :language: yaml
  :linenos:

.. _microsoft-teams-notifications-technical-user:
.. rubric:: Technical User

Visit the `Microsoft 365 admin center <https://admin.microsoft.com/>`_ and
create a new user by navigating to **Users** > **Active users** and clicking on
**Add a user**. Give the user a display name that represents your Ivy Portal
(e.g. "Ivy"). Other users will receive notifications in the form of chat
messages by this user. Remove the checkmarks for **Automatically create a
password** and **Require this user to change their password when they first sign
in**. Provide the user with a secure password and keep note of it. Also, provide
the user with a product license to be able to use Microsoft Teams.

.. figure:: /_images/notifications/technical-user-1.png
  :alt: Add a user - Set up the basics

.. figure:: /_images/notifications/technical-user-2.png
  :alt: Add a user - Assign product licenses

After creating the user, turn off multifactor authentication by clicking on the
user and then **Manage multifactor authentication**. Make sure no other policies
require the user to change their password regularly or prevent them from logging
in for any other reasons.

.. figure:: /_images/notifications/technical-user-3.png
  :alt: Manage multifactor authentication

Add the mail address (`TechnicalUser.Mail`) and password
(`TechnicalUser.Password`) of the technical user to the configuration of the
Microsoft Teams Notification Channel.

.. _microsoft-teams-notifications-application:
.. rubric:: Application

Visit the `Microsoft Entra admin center <https://entra.microsoft.com/>`_ and
follow `these instructions
<https://learn.microsoft.com/en-us/entra/identity-platform/quickstart-register-app>`_
to register an application with the Microsoft identity platform. On step 5,
choose **Accounts in this organizational directory only**.

.. figure:: /_images/notifications/application-1.png
  :alt: Register an application

Navigate to **Applications** > **Enterprise Applications** and click on the
newly registered application. Navigate to **Properties** in the section
**Manage**. Set **Assignment required?** to **Yes**.

.. figure:: /_images/notifications/application-2.png
  :alt: Application - Properties

Navigate to **Users and Groups** in the section **Manage**. Click on **Add
user/group** > **Users and groups** and search for, select, and assign the
technical user you created before. (See :ref:`Technical
User<microsoft-teams-notifications-technical-user>`)

.. figure:: /_images/notifications/application-3.png
  :alt: Application - Users and groups

Navigate to **Applications** > **App registrations** and click on the newly
registered application. If you can not see it, make sure to change the selected
tab to **All applications**. Navigate to **Authentication** in the section
**Manage**. Set **Allow public client flows** to **Yes**.

.. figure:: /_images/notifications/application-4.png
  :alt: Application - Authentication

Navigate to **API permissions** in the section **Manage**. Click on **Add a
permission** > **Microsoft Graph** > **Delegated permissions** and search for,
select, and add the following permissions:

- Chat.Create
- ChatMessage.Send
- User.Read

Click on **Grant admin consent for <tenant>** above the table with the
permissions and confirm the dialog.

.. figure:: /_images/notifications/application-5.png
  :alt: Application - API permissions

Add the ID of your tenant (`TenantId`) and newly created application
(`ClientId`) to the configuration of the Microsoft Teams Notification Channel.
