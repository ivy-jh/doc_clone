.. _config-email:

Email
=====

The Axon Ivy Engine sends emails for different purposes:

* In-process mails. Sent within a process via the mail step.
* Notifications via the :ref:`mail notification channel <notification-mail>`.
* License violations mails to the administrators.

For the Axon Ivy Engine to be able to send emails, you have to configure an
email server in :ref:`ivy-yaml`: 

.. literalinclude:: includes/ivy-email.yaml
  :language: yaml
  :linenos:

Users can customize their notification settings in the Portal.

If you need to send emails with OAuth2 on office365.com, you can follow this
guide here: https://community.axonivy.com/d/968-send-emails-via-smtp-using-oauth2-authentication-on-office365com
