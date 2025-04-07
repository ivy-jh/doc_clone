.. _html-dialogs-csrf:

CSRF Protection
---------------

HTML Dialogs using the JSF technology are well protected from Cross-site Request
Forgery (CSRF) attacks:

- Since version 2.0, JSF is quite well protected from CSRF attacks by its
  ``ViewState`` concept, using a randomly generated ID as its value.
- Postback views are automatically protected; non-postback views need to be
  configured to be protected, but are not a valid attack scenario.
- Since JSF 2.2, even non-postback views, stateless views, and views with client
  side state can be or are protected by default.

.. note::

  Since the JSF ``ViewState`` concept is not based on the usual X-CSRF header token
  schema, some penetration testing tools will show a false vulnerability for CSRF
  attacks. They expect a header token in the server response, which is not needed in
  this case and, if included, will be ignored by the Axon Ivy Engine.
