#
# This file is the gmiimux recipe.
#

SUMMARY = "Simple gmiimux application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://ps_gmii_off \
     file://ps_gmii_on \
     file://pl_gmii_off \
     file://pl_gmii_on \
     file://pl_gmii_off \
	"

S = "${WORKDIR}"

do_install() {
	     install -d ${D}/${bindir}
	     install -m 0755 ${S}/ps_gmii_off ${D}/${bindir}
	     install -m 0755 ${S}/ps_gmii_on ${D}/${bindir}
	     install -m 0755 ${S}/pl_gmii_off ${D}/${bindir}
	     install -m 0755 ${S}/pl_gmii_on ${D}/${bindir}
}
