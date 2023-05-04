#
# This file is the pipelines recipe.
#

SUMMARY = "Simple pipelines application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://dahua_pipeline_0 \
           file://dahua_pipeline_1 \
           file://dahua_pipeline_2 \
           file://econ_pipeline_0 \
           file://econ_pipeline_0.1 \
           file://econ_pipeline_1 \
           file://econ_pipeline_1.1 \
	"

S = "${WORKDIR}"

do_install() {
	     install -d ${D}/${bindir}
	     install -m 0755 ${S}/dahua_pipeline_0 ${D}/${bindir}
	     install -m 0755 ${S}/dahua_pipeline_1 ${D}/${bindir}
	     install -m 0755 ${S}/dahua_pipeline_2 ${D}/${bindir}
	     install -m 0755 ${S}/econ_pipeline_0 ${D}/${bindir}
	     install -m 0755 ${S}/econ_pipeline_0.1 ${D}/${bindir}
	     install -m 0755 ${S}/econ_pipeline_1 ${D}/${bindir}
	     install -m 0755 ${S}/econ_pipeline_1.1 ${D}/${bindir}
}
