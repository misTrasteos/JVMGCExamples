# JstatExample
## How to ...

### ... run
```
jbang run JstatExample.java
```

### ... jstat
```
jstat -gc $(jps | grep JstatExample | cut -d " " -f1) 1s
```

# OQLExample

## How to ...

### ... run
```
jbang run HeapDumpAndHistogramExample.java
```

### ... query in OQL from Eclipse MAT

```
select * from "oql.example.*"
```

# Heap Dump and Histogram Example

## How to ...

### ... run
```
jbang run HeapDumpAndHistogramExample
```
### ... heap dump of all objects (live and dead)

```
jmap -dump:,format=b,file=all.hprof $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)
```

### ... heap dump of only live objects
This will force a FullGC

```
jmap -dump:live,format=b,file=live.hprof $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)
```

### ... all objects histogram (live and dead)

```
jmap -histo $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)
```

### ... live objects histogram
This will force a FullGC

```
jmap -histo:live $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)
```

# VisualVMExample
## How to ...

### ... run
```
jbang run VisualVMExample.java
```

# JFREventsExample

## How to ...

### ... run

```
jbang --jfr=filename=JFREventsExample.jfr JFREventsExample.java
```