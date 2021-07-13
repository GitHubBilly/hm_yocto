SUMMARY = "WPEB-265AXI(BT) external Linux kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://include/* \
		       file://* \
           file://COPYING \
          "

S = "${WORKDIR}"

FILES_${PN} += " /lib/*"

do_install(){
  # Copy all firmware and NVRAM files to your target system (ex: /lib/firmware/bcmdhd)
  TARGET=${D}/lib/firmware/bcmdhd
  install -m 0755 -d ${TARGET}
  install -m 0644 ${WORKDIR}/bcmdhd.ko ${TARGET}/bcmdhd.ko
  install -m 0644 ${WORKDIR}/FW_AP6275P/BCM4362A2_001.003.006.0010.0010.btp ${TARGET}/BCM4362A2_001.003.006.0010.0010.btp
  install -m 0644 ${WORKDIR}/FW_AP6275P/BCM4362A2_001.003.006.0016.0018_sLNA_iLNA_CL1.hcd ${TARGET}/BCM4362A2_001.003.006.0016.0018_sLNA_iLNA_CL1.hcd
  install -m 0644 ${WORKDIR}/FW_AP6275P/clm_bcm43752a2_pcie_ag.blob ${TARGET}/clm_bcm43752a2_pcie_ag.blob
  install -m 0644 ${WORKDIR}/FW_AP6275P/fw_bcm43752a2_pcie_ag.bin ${TARGET}/fw_bcm43752a2_pcie_ag.bin
  install -m 0644 ${WORKDIR}/FW_AP6275P/fw_bcm43752a2_pcie_ag_apsta.bin ${TARGET}/fw_bcm43752a2_pcie_ag_apsta.bin
  install -m 0644 ${WORKDIR}/FW_AP6275P/nvram_ap6275p.txt ${TARGET}/nvram_ap6275p.txt
  install -m 0644 ${WORKDIR}/FW_AP6275P/nvram_ap6275p_m2.txt ${TARGET}/nvram_ap6275p_m2.txt
  install -m 0644 ${WORKDIR}/FW_AP6275P/ReadMe.txt ${TARGET}/ReadMe.txt
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-bcmdhd"

# KERNEL_MODULE_AUTOLOAD_append_intel-corei7-64 = " bcmdhd"

