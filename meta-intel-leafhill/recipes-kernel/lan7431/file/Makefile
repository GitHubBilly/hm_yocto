#
# Makefile for the Microchip network device drivers.
#

#obj-$(CONFIG_ENC28J60) += enc28j60.o
#obj-$(CONFIG_ENCX24J600) += encx24j600.o encx24j600-regmap.o
#obj-$(CONFIG_LAN743X) += lan743x.o
obj-m := lan743x.o

lan743x-objs := lan743x_main.o lan743x_ethtool.o lan743x_ptp.o

SRC := $(shell pwd)

all:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
	rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
	rm -f Module.markers Module.symvers modules.order
	rm -rf .tmp_versions Modules.symvers
