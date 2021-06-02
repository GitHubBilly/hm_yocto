SUMMARY = "Lan7431 external Linux kernel module"
LICENSE = "GPLv2"

inherit module

SRC_URI = "file://Makefile \
           file://Kconfig \
           file://lan743x_ethtool.c \
           file://lan743x_ethtool.h \
           file://lan743x_main.c \
           file://lan743x_main.h \
           file://lan743x_ptp.c \
           file://lan743x_ptp.h \
          "

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-lan7431"
