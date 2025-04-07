Advanced Configuration
======================

.. _advanced-configuration-passwords:

Passwords
---------

You may want to encrypt sensitive data like passwords in your configuration
files. To do this, you can enclose any value with ``"${encrypt:}"``. The
Axon Ivy Engine will automatically encrypt and replace that value in the file when the
configuration is loaded. The system database password can be encrypted as
follows:

.. literalinclude:: includes/ivy-password.yaml
    :language: yaml
    :linenos:

There is a smooth :ref:`configuration_containers_secrets` integration, which is very useful in container
environments such as Docker. Be aware that :ref:`passwords of administrators <engine-administrators>` always should be hashed.


.. _configuration-language:

Language
--------

In each security system a default content language and a default formatting
language can be defined. The content language is used to display the content in
HTML dialog when loading content from the cms. This setting is also used to
generate notification mails. The formatting language can be set additionally and
is used to format values, for example the decimal point is displayed differently
in different regions of the world. 

.. literalinclude:: includes/ivy-language.yaml
    :language: yaml
    :linenos:

Users can customize the content language and formatting language in their
profile independently. You can add new translations for the built-in task
mail notifications in :file:`[engineDir]/system/cms`.

.. _configuration-business-calendar:

Business Calendar
-----------------

A business calendar defines the official business hours and business days.
These settings are used for business calendar calculations, e.g., what date will
it be in three business days.
See at :ref:`Designer Guide <business-calendar>`
and :public-api:`IBusinessCalendar </ch/ivyteam/ivy/application/calendar/IBusinessCalendar.html>`
for more information.

It is defined in the application's :ref:`app-yaml`. An application contains
at least one business calendar; if none is defined, a default calendar is
automatically generated.

Here is an example of a business calendar definition;
see :ref:`app-yaml` for more detailed information.

.. literalinclude:: ../../../target/resources/includes/configuration/templates/app-businesscalendar.yaml
  :language: yaml
  :linenos:


HTML Theme
----------

The look and feel of HTML Dialogs is defined by its theme. You can change the
appearance of any dialog on several scopes:

* Globally for all HTML Dialogs via :ref:`web-xml`. 
* For a single application in the :ref:`app-yaml`.

.. literalinclude:: includes/ivy-primefaces-app.yaml
  :language: yaml
  :linenos:

* Or at session level via the :public-api:`IvyPrimefacesThemeResolver </ch/ivyteam/ivy/jsf/primefaces/theme/IvyPrimefacesThemeResolver.html>`.

.. _configuration-cron:

CRON Expression
---------------

You can use a `CRON <https://en.wikipedia.org/wiki/Cron>`_ expression in configurations that specify when a certain job should be executed. 
A `CRON <https://en.wikipedia.org/wiki/Cron>`_ expression contains 5 fields:

.. code-block:: 

    ┌───────────── Minute (0 - 59)
    │ ┌───────────── Hour (0 - 23)
    │ │ ┌───────────── Day of the month (1 - 31)
    │ │ │ ┌───────────── Month (1 - 12)
    │ │ │ │ ┌───────────── Day of the week (0 - 6) (Sunday to Saturday)
    │ │ │ │ │
    │ │ │ │ │
    * * * * *
    
Example:

.. code-block::

    45 23 * * 6
    
This expression will trigger a job every Saturday at 23:45.

The following values are allowed per field:

+------------------+-----------------+----------------------------+
| Field            | Allowed values  | Allowed special characters |
+==================+=================+============================+
| Minute           | 0-59            | * , -                      |
+------------------+-----------------+----------------------------+
| Hour             | 0-23            | * , -                      |
+------------------+-----------------+----------------------------+
| Day of the month | 1-31            | * , - L W                  |
+------------------+-----------------+----------------------------+
| Month            | 1–12 or JAN–DEC | * , -                      |
+------------------+-----------------+----------------------------+
| Day of the week  | 0–6 or SUN–SAT  | * , - L                    |
+------------------+-----------------+----------------------------+

Asterisk ( :code:`*` )
""""""""""""""""""""""
 
Asterisks (also known as wildcard) represents "all". For example, using :code:`* * * * *` will run every minute. Using :code:`* * * * 1` 
will run every minute only on Monday.

Comma ( :code:`,` )
"""""""""""""""""""

Commas are used to separate items of a list. For example, using :code:`MON,WED,FRI` in the 5th field (day of week) means Mondays, Wednesdays and Fridays.

Dash ( :code:`-` )
""""""""""""""""""

Dash defines ranges. For example, :code:`TUE-FRI` indicates every day from Tuesday to Friday, inclusive.

Last ( :code:`L` )
""""""""""""""""""

:code:`L` stands for "last". When used in the day-of-week field, it allows specifying constructs such as "the last Friday" (:code:`5L`) of a given month. 
In the day-of-month field, it specifies the last day of the month.

Weekday (:code:`W` )
""""""""""""""""""""
    
The :code:`W` character is allowed for the day-of-month field. This character is used to specify the weekday (Monday-Friday) nearest the given day.
As an example, if :code:`15W` is specified as the value for the day-of-month field, the meaning is: "the nearest weekday to the 15th of the month." 
So, if the 15th is a Saturday, the trigger fires on Friday the 14th. If the 15th is a Sunday, the trigger fires on Monday the 16th. 
If the 15th is a Tuesday, then it fires on Tuesday the 15th. However, if :code:`1W` is specified as the value for day-of-month, and the 1st 
is a Saturday, the trigger fires on Monday the 3rd, as it does not 'jump' over the boundary of a month's days. 
The :code:`W` character can be specified only when the day-of-month is a single day, not a range or list of days.        

Overriding Configuration
------------------------

Configuration entries of YAML files can be overridden with environment variables
of the operating system. Configuration keys in YAML are hierarchic object trees
separated by :code:`:` characters. While the environment variable must be
written uppercase and separated by :code:`_` characters. You need also to prefix
the environment variable with :code:`IVY_`.

So to overwrite the :code:`SystemDb:Url` of the :ref:`ivy-yaml` file, the
environment variable :code:`IVY_SYSTEMDB_URL` must be set.
