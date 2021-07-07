SUMMARY = "FM150 external Linux kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://Makefile \
           file://GobiUSBNet.c \
		   file://QMI.c \
		   file://QMI.h \
		   file://QMIDevice.c \
		   file://QMIDevice.h \
		   file://ReleaseNote.txt \
		   file://Structs.h \
		   file://COPYING \
          "

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-gobinet"

KERNEL_MODULE_AUTOLOAD_append_intel-corei7-64 = " gobinet"