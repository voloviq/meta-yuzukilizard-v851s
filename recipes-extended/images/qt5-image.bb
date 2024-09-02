DESCRIPTION = "Qt5 image for Yuzuki-Lizard V851s"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "
GLIBC_GENERATE_LOCALES="pl_PL.UTF-8"

IMAGE_LINGUAS:append = " pl-pl"

inherit core-image
inherit populate_sdk_qt5

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    devmem2 \
    rsync \
    minicom \
    tcpdump \
"

QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qtserialport \
    qtsvg \
    qt5-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
    fonts \
"

FB_TOOLS = " \
    fb-test \
    fbset-modes \
    fbset \
    libdrm-tests \
"

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtquickcontrols-qmlplugins \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

DEV_TOOLS_INSTALL = " \
    mtd-utils \
"

UTILITIES_INSTALL = " \
    strace \
    vim \
    htop \
    lsof \
    coreutils \
    gdbserver \
    ldd \
    libstdc++ \
    libstdc++-dev \
    resize-rootfs \
    ppp \
    parted \
    e2fsprogs \
    e2fsprogs-resize2fs \
    usb-gadget-dhcp \
    os-release \
    lsb-release \
    usbutils \
    libgpiod \
    libgpiod-tools \
    libgpiod-dev \
    libxcb \
    psplash \
    usbutils \
    libusbgx \
    libxcb \
    nano \
"

USER_APPLICATION = " \
\
"

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-dev \
    tslib-tests \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

WIFI_TOOLS = " \
    wpa-supplicant \
    iw \
"

IMAGE_INSTALL:append = " glibc-utils localedef"

IMAGE_INSTALL += " \
  ${QT_DEV_TOOLS} \
  ${DEV_TOOLS_INSTALL} \
  ${SYSTEM_TOOLS_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${FONTS} \
  ${FB_TOOLS} \
  ${QT_TOOLS} \
  ${KERNEL_EXTRA_INSTALL} \
  ${TSLIB} \
"
