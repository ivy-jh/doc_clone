.. _cms-content-resolution:

Content resolution
******************

As soon as a content object is loaded, the content object will be resolved as follows:

#. Application CMS (:file:`[engineDir]/data/{app}/cms`)
#. Current project
#. Dependent projects

Once the content object is found, the concrete content object value must be
evaluated. For this purpose, the locale must be defined first:

#. Locale from :public-api:`session </ch/ivyteam/ivy/security/ISession.html#getContentLocale()>`
#. Locale from :public-api:`user </ch/ivyteam/ivy/security/IUser.html#getLanguage()>`
#. Locale from browser
#. Locale from security system configuration :code:`Language.Content` in :ref:`ivy-yaml`

*If you have enabled the* :ref:`simulation <language-settings>` *then the locale will be applied to all sessions.*

Once the locale has been evaluated, the content object value is loaded as
follows:

#. Same locale of current locale (language and region)
#. Same language of current locale (only language)
#. Same locale of security system locale (language and region)
#. Same language of security system locale (only language)
#. Value with no locale
#. First value
