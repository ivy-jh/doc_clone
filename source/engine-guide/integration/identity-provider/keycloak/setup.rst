.. _keycloak-setup:

Create Client in Keycloak
-------------------------

1. Create a client in your realm. Don't use the master realm, this is only for
   Keycloak admins.
  
  1. Use :code:`OpenID Connect` as :guilabel:`Client Type`
  2. Choose a :guilabel:`Client ID` of your choice e.g. :code:`ivy-client`

  .. figure:: /_images/keycloak/keycloak-step-1.png

  3. Click on :guilabel:`Next`
  4. Turn on :guilabel:`Client authentication`
  5. Ènable :guilabel:`Service accounts roles`

  .. figure:: /_images/keycloak/keycloak-step-2.png

  6. Click on :guilabel:`Next`
  7. Define the URLs, wherever the login screen of Keycloak should be available.
     To improve security also define :guilabel:`Valid redirect URLs`, which need to point
     to your Axon Ivy Engine e.g. :code:`https://ivy-engine/oauth2/callback`.

  .. figure:: /_images/keycloak/keycloak-step-3.png

  8. Click on :guilabel:`Save`

2. You can now go to the tab :guilabel:`Credentials` and retrieve the :guilabel:`ClientSecret` which
   is needed as part of the Keycloak configuration in :ref:`ivy.yaml <keycloak>`.

   .. figure:: /_images/keycloak/keycloak-step-4.png

3. Go to the tab :guilabel:`Service account roles` and assign the role
   :guilabel:`role-management view-users`. This is needed so that the Axon Ivy
   Engine can synchronize users.

   .. figure:: /_images/keycloak/keycloak-step-5.png

4. If you want to synchronize the language of your users then you need to enable
   localization in your realm.
   
   1. Go to the realm settings
   2. Click on tab :guilabel:`Localization`
   3. Toggle the button :guilabel:`Internationalization` to :guilabel:`Enabled`

