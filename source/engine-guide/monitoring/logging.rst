.. _logging:

Logging
=======

In order to successfully run an Axon Ivy Engine, you need to be prepared in
case of errors or even failures. Therefore mission critical events are logged.
Each event has a level:

* **FATAL** systems runs partially or not at all
* **ERROR** something is not working properly
* **WARNING** warning which can lead someday to an error
* **INFO** neutral message
* **DEBUG/TRACE** low-level events, needed for troubleshooting

Axon Ivy comes with a sophisticated :ref:`default log configuration <log4j2-xml>`
which logs all warning, error and fatal events in the :file:`logs`
directory of the Axon Ivy Engine. The log files will be rotated and compressed
every day.

Keep in mind that an unfavorable log configuration can lead to failures.
For example, if the root log level is set to DEBUG, so many logs are written
that the engine has no more resources for other tasks.


Customization
-------------

The logging configuration can be fully customized to your needs.
For example, you can change the log level of a logger so that the log events are logged in a log file.
Therefore you need to know that
Axon Ivy uses `Log4j 2 <https://logging.apache.org/log4j/2.x/>`_ for logging and
comes with a built-in :ref:`default configuration <log4j2-xml>` which can be 
customized by providing a configuration in :file:`[engineDir]/configuration/log4j2.xml`.
The custom configuration will be `merged <http://logging.apache.org/log4j/2.x/manual/configuration.html#CompositeConfiguration>`_
with the default configuration automatically on the fly.


Runtime Log
-----------

The Runtime Log is a well-known :ref:`designer feature <simulate-process-models-debugger-runtimelog-view>` and disabled by default
in the Axon Ivy Engine to prevent a flood of log messages, which can decrease
performance and filling the disk.
But you can set the log level of a specific runtime logger and bring them even to another file to get the logs also on the Axon Ivy Engine.

The name of the runtime logger has a well defined format:

**runtimelog.[security context name].[category].[app name].[process model name]**

**Example:**

.. literalinclude:: ../../../target/resources/includes/configuration/templates/log4j2-runtimelog.xml
  :language: xml
  :linenos:

All available categories [category] are defined in the :public-api:`RuntimeLogCategory
</ch/ivyteam/ivy/application/RuntimeLogCategory.html>`. Write them in lower case
e.g., :code:`<Logger name="runtimelog.securitycontext.rest_client.myapp.hrm">`. 


Log format
----------

A single event can be found as a log entry in the format
**[datetime][level][logger name][thread name]{context infos}** followed by the message itself like:

.. literalinclude:: includes/log-message.log
