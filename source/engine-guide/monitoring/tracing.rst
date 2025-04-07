.. _tracing:

Request Tracing
===============

The tracing of requests allows you to find slow requests and analyze where those requests spend time 
(e.g., on which internal or external system a request spends time or is waiting).  
 
Engine Cockpit
--------------

You can activate and analyze the request tracing in the
:ref:`engine-cockpit-monitor-slow-requests` view of the :ref:`engine-cockpit`.

Logging
-------

If you experience poor performance, you can log the individual requests
to the Axon Ivy Engine log by setting the level of the request performance logger in :file:`[engineDir]/configuration/log4j2.xml`:

.. literalinclude:: ../../../target/resources/includes/configuration/templates/log4j2-performance-request.xml
  :language: xml
  :linenos:

This will create a log entry when the request has been received by the internal web server
and when the request has been processed with the time spent for processing.

A unique request identifier **requestId** is assigned to every request. This can be used
to find out what the Axon Ivy Engine did while processing the request.

**Example:**

.. literalinclude:: includes/request-tracing.log
  :language: none

The example above shows the log messages when the request with id **61** has entered
and exited the web server. During the request a database :code:`SELECT` statement has been executed.
The whole request has been processed in 16 ms.

Request Tracing Tools
.....................

You can use a external tracing tool that propagates a trace id in a HTTP header.
In that case, Axon Ivy will re-use the given trace Id as its **requestId**.
This allows you to aggregate log entries from different systems using the
**requestId**. Axon Ivy Engine supports the following HTTP headers:

=================  =============      
HTTP Header        Tool/Standard
=================  =============
traceparent        `W3C Trace Context <https://www.w3.org/TR/trace-context/>`_
uber-trace-id      `Jaeger <https://www.jaegertracing.io>`_
b3                 `Zipkin <https://zipkin.io/>`_
X-B3-TraceId       `Zipkin <https://zipkin.io/>`_
X-Amzn-Trace-Id    `Amazon X-Ray <https://docs.aws.amazon.com/xray>`_
ot-tracer-traceid  `Open Tracing <https://github.com/opentracing>`_
=================  =============

For a deeper integration with a tracing tool have a look at our :link-url:`Jaeger Tracing <docker-tracing-jaeger>` 
(`Jaeger <https://www.jaegertracing.io>`_ and  `OpenTelemetry <https://opentelemetry.io/>`_) example.
