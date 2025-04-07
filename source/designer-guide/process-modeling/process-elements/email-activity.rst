.. _process-element-email-activity:

E-Mail Activity
================

|image0| The *E-Mail Activity* element is located in the *Activity* drawer
of the process editor palette.

Element Details
---------------

This element allows to send e-mails out of processes (e.g., for
information or alert purposes). The configuration must be set in
the :ref:`ivy.yaml <config-email>`.

With the default E-Mail preferences mails will be sent to the 'Mail Messages'
view of the Designer.

Inscription
-----------

.. include:: _tab-name.rst

Tab Header
~~~~~~~~~~

In this tab the e-mail header is defined. You can use the :ref:`cms` 
and the process data (the ``in`` variable) to compose
the header fields.

.. figure:: /_images/process-inscription/mail-tab-header.png
   :alt: Header Tab

   Header Tab

Subject
   The title of the e-mail to send.

From
   The sender of the e-mail (always use a valid e-mail address).

Reply to
   The e-mail address which is used by most e-mail clients when the
   reader clicks on "Reply" or "Reply all". Always use a valid e-mail
   address.

To
   The recipient(s) of the e-mail. Multiple recipients can be separated
   by a comma or semi-colon.

CC
   The recipient(s) in carbon copy of the e-mail. Multiple recipients
   can be separated by a comma or semi-colon.

BCC
   The recipient(s) in blind carbon copy of the e-mail. Multiple
   recipients can be separated by a comma or semi-colon.

Error
   Is thrown whenever an error occurs during the execution of this
   element. The error can be handled by a catching
   :ref:`process-element-error-start` or by an
   :ref:`process-element-error-boundary-event`.

Tab Content
~~~~~~~~~~~

In this tab the e-mail content is defined.

.. figure:: /_images/process-inscription/mail-tab-content.png
   :alt: Content Tab

   Content Tab

Message
   The text of the e-mail. Use the :ref:`cms` to have messages
   in multiple languages.

   .. tip::

      You can send HTML formatted mails by setting the content-type ``type=text/html``.
      Consequently you can use html tags, such as ``<h1>`` or ``<b>`` in your message content.

Tab Attachments
~~~~~~~~~~~~~~~

In this tab you can attach files to your e-mail. 
Attachments can be provided as single ``File`` process data reference 
or with a ``List<File>`` reference to supply multiple files at once.
Alternatively files can be selected from the CMS.
Finally, files can be added by stating a ``String`` path. It will by resolved by
searching the name as file in your :ref:`file area <ivyscript-reference-file>`.

.. figure:: /_images/process-inscription/mail-tab-attachments.png
   :alt: Attachment Tab

   Attachment Tab

.. |image0| image:: /_images/process-editor/elements/mail.png
