#
# This file is the r5 recipe.
#

SUMMARY = "Simple r5 application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://r5.elf \
	"

S = "${WORKDIR}"
INSANE_SKIP:${PN} = "arch"

do_install() {
       install -d ${D}${base_libdir}/firmware
       install -m 0644 ${S}/r5.elf ${D}${base_libdir}/firmware/r5.elf
}

FILES:${PN} = "${base_libdir}/firmware/r5.elf"
