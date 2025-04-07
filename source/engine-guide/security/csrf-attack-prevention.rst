CSRF Attack Prevention
======================

In a Cross-site Request Forgery (CSRF) attack, a HTTP request gets sent from a
victim's browser to a usually authenticated target destination in order to perform
an action as the victim.

Ivy applications are well protected from this kind of attack under the following
conditions:

- You are using our standard :ref:`html-dialogs` (JSF) technology stack. See
  :ref:`HD CSRF Protection <html-dialogs-csrf>` on how JSF is protecting these dialogs.

- For REST calls the setting ``REST.Servlet.CSRF.Protection`` is set to true. This
  is also the default setting. See :ref:`Secure REST APIs <integration-rest-secure>`
  for more information.
