.. _engine-notification:

Notification
============

The |ivy-engine| sends :ref:`notifications<notification>` to users such as when a
new task is assigned to a user. Different channels can be operated.
Built-in channels are the following:

.. toctree::
   :maxdepth: 1

   web
   mail
   microsoft-teams

By default, only the web channel is active, which displays all notifications.
Each channel can be configured individually.

.. literalinclude:: ivy-notification.yaml
  :language: yaml
  :linenos:

.. rubric:: Notification on absent users

There is a global option to disable notifications if a user is absent; if no property is set, they will act like :code:`NotifyAbsentUser:always`.

- Send a notification regardless of the user's absence: :code:`always`
- Does not send a notification if the user is absent: :code:`never`
- Send a notification only the absent user does not have an active substitute: :code:`noActiveSubstitute`

.. rubric:: Events

You can configure which events are sent over which channels. If nothing is
configured all Events are distributed over the given channel. If you disable
`Events:AllKinds` and specify `Events:Kinds` for a channel only those events are
sent. However, users can individually set the notification settings in Axon Ivy
Portal. All available events are:

- **new-task**: If a user has a new task assignment (also on delegation)
- **business**: If new business relevant event happens or new business information is available 

.. rubric:: Cleanup

By default, notifications are deleted from the database if they are older than
90 days. This duration can be adjusted using the `Cleanup:DaysUntilDeletion`
property.
