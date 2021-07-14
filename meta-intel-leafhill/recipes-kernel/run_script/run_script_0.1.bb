SUMMARY = "run script"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

PN = 'run_script' 
#PV = '0' 
#PR = "r1"

SRC_URI = "file://bcmdhd_run.sh \
           file://fm150_run.sh \
       	   file://wnfq-261ac_run.sh \
		   file://COPYING \
          "

FILES_${PN} += " ${bindir}/*"

do_install(){
  TARGET=${D}${bindir}/run_script/
  install -m 0755 -d ${TARGET}
  install -m 0644 ${WORKDIR}/bcmdhd_run.sh ${TARGET}/bcmdhd_run.sh
  install -m 0644 ${WORKDIR}/fm150_run.sh ${TARGET}/fm150_run.sh
  install -m 0644 ${WORKDIR}/wnfq-261ac_run.sh ${TARGET}/wnfq-261ac_run.sh
}

addtask do_install after do_transform_template
